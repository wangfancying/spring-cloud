package com.hui.wang.spring.cloud.context;

/**
 * 用户信息
 *
 * @author hui.wang09
 * @since 17 十月 2018
 */
public class UserContext {


	public static final String AUTH_TOKEN = "tmx-auth-token";

	public static final String USER_ID = "tmx-user-id";


	private String authToken = new String();

	private String userId = new String();


	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserContext{" +
				"authToken='" + authToken + '\'' +
				", userId='" + userId + '\'' +
				'}';
	}
}
