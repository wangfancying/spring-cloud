package com.hui.wang.spring.cloud.hystrix.strategy;

import java.util.concurrent.Callable;

import com.hui.wang.spring.cloud.context.UserContext;
import com.hui.wang.spring.cloud.context.UserInfo;
import org.apache.log4j.Logger;

import org.springframework.util.Assert;

/**
 * 定义一个Java callable 类，将UserContext注入Hystrix命令中
 *
 * @author hui.wang09
 * @since 18 November 2018
 */
public class DelegatingUserContextCallable<V> implements Callable<V>{

	private final Logger LOGGER = Logger.getLogger(DelegatingUserContextCallable.class);

	private final Callable<V> delegate;

	private UserInfo originalUserInfo;

	public DelegatingUserContextCallable(Callable<V> delegate, UserInfo userInfo) {
		Assert.notNull(delegate, "delegate cannot be null");
		Assert.notNull(userInfo, "userContext cannot be null");

		this.delegate = delegate;
		this.originalUserInfo = userInfo;
	}

	public DelegatingUserContextCallable(Callable<V> delegate) {
		this(delegate, UserContext.getUserInfo());
	}

	@Override
	public V call() throws Exception {
		UserContext.setContext(originalUserInfo);

		try {
			return delegate.call();
		} finally {
			this.originalUserInfo = null;
		}
	}

	public static <V> Callable<V> create(Callable<V> delegate, UserInfo userContext) {
		return new DelegatingUserContextCallable<V>(delegate, userContext);
	}
}
