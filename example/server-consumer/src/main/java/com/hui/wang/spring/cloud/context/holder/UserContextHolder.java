package com.hui.wang.spring.cloud.context.holder;

import com.hui.wang.spring.cloud.context.UserContext;

import org.springframework.util.Assert;

/**
 * 使用ThreadLocal保存用户信息
 *
 * @author hui.wang09
 * @since 17 十月 2018
 */
public class UserContextHolder {

	private static final ThreadLocal<UserContext> userContext = new ThreadLocal<UserContext>();

	public static final UserContext getContext() {
		UserContext context = userContext.get();

		if (context == null) {
			context = createEmptyContext();
			userContext.set(context);

		}
		return userContext.get();
	}

	public static final void setContext(UserContext context) {
		Assert.notNull(context, "Only non-null UserContext instances are permitted");
		userContext.set(context);
	}

	public static final UserContext createEmptyContext() {
		return new UserContext();
	}

}
