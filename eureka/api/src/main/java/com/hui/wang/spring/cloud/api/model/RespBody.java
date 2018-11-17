package com.hui.wang.spring.cloud.api.model;

import java.io.Serializable;

/**
 *
 * @author hui.wang09
 * @since 15 November 2018
 */
public class RespBody implements Serializable{

	private String result;
	private String request;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
}
