package com.hui.wang.spring.cloud.trace.api.model;

import java.util.Date;

/**
 * trace model
 *
 * @author hui.wang09
 * @since 19 November 2018
 */
public class Trace {

	private String traceId;
	private Date createTime;

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
