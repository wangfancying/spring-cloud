package com.hui.wang.spring.cloud.api.model;

import java.io.Serializable;

/**
 *
 * @author hui.wang09
 * @since 15 November 2018
 */
public class ReqBody implements Serializable{

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
