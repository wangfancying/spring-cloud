package com.hui.wang.spring.cloud.strategy;

import java.util.concurrent.Callable;

import com.hui.wang.spring.cloud.context.UserContext;
import com.hui.wang.spring.cloud.context.holder.UserContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.Assert;

/**
 * 定义一个Java callable 类，将UserContext注入Hystrix命令中
 *
 * @author hui.wang09
 * @since 17 十月 2018
 */
public class DelegatingUserContextCallable<V> implements Callable<V> {

	private static final Logger logger = LoggerFactory.getLogger(DelegatingUserContextCallable.class);

	private final Callable<V> delegate;

	private UserContext originalUserContext;

	public DelegatingUserContextCallable(Callable<V> delegate, UserContext originalUserContext) {
		Assert.notNull(delegate, "delegate cannot be null");
		Assert.notNull(originalUserContext, "userContext cannot be null");

		this.delegate = delegate;
		this.originalUserContext = originalUserContext;
	}

	public DelegatingUserContextCallable(Callable<V> delegate) {
		this(delegate, UserContextHolder.getContext());
	}

	@Override
	public V call() throws Exception {
		UserContextHolder.setContext(originalUserContext);

		try {
			return delegate.call();
		} finally {
			this.originalUserContext = null;
		}
	}

	public static <V> Callable<V> create(Callable<V> delegate, UserContext userContext) {
		return new DelegatingUserContextCallable<V>(delegate, userContext);
	}
}
