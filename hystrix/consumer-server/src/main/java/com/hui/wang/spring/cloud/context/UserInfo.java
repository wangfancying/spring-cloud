package com.hui.wang.spring.cloud.context;

import java.io.Serializable;

/**
 * 用户信息 model
 *
 * @author hui.wang09
 * @since 18 November 2018
 */
public class UserInfo implements Serializable{

	public static final String USER_ID = "user_id";
	public static final String USER_TOKEN = "user_token";

	private String userId;
	private String userToken;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"userId='" + userId + '\'' +
				", userToken='" + userToken + '\'' +
				'}';
	}
}
