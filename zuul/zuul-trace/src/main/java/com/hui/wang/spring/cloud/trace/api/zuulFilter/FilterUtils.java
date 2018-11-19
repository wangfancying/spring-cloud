package com.hui.wang.spring.cloud.trace.api.zuulFilter;

import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author hui.wang09
 * @since 19 November 2018
 */
public class FilterUtils {

	public static final String TRACE_ID = "trace_id";

	/**
	 * 获取随机ID
	 */
	public static String generateTraceId() {
		return java.util.UUID.randomUUID().toString();
	}

	/**
	 * 获取traceId
	 */
	public static String getTraceId() {
		RequestContext requestContext = RequestContext.getCurrentContext();

		if (StringUtils.isNotEmpty(requestContext.getRequest().getHeader(TRACE_ID))) {
			return requestContext.getRequest().getHeader(TRACE_ID);
		}
		return requestContext.getZuulRequestHeaders().get(TRACE_ID);
	}

	/**
	 * 设置traceId
	 */
	public static void setTraceId() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		requestContext.addZuulRequestHeader(TRACE_ID, generateTraceId());
	}
}
