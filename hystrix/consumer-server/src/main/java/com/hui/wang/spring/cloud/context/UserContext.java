package com.hui.wang.spring.cloud.context;

import java.util.Objects;

import org.springframework.util.Assert;

/**
 * 保存用户信息上线文
 *
 * @author hui.wang09
 * @since 18 November 2018
 */
public class UserContext {

	private static final ThreadLocal<UserInfo> USER_CONTEXT = new ThreadLocal<>();

	/**
	 * 获取用户信息
	 */
	public static UserInfo getUserInfo() {
		UserInfo userInfo = USER_CONTEXT.get();

		if (Objects.isNull(userInfo)) {
			userInfo = create();
			USER_CONTEXT.set(userInfo);
		}
		return USER_CONTEXT.get();
	}

	private static UserInfo create() {
		return new UserInfo();
	}

	/**
	 * 保存用户信息
	 */
	public static void setContext(UserInfo userInfo) {
		Assert.notNull(userInfo, "Only non-null UserContext instances are permitted");
		USER_CONTEXT.set(userInfo);
	}

	/**
	 * 销毁
	 */
	public static void clean() {
		USER_CONTEXT.remove();
	}
}
