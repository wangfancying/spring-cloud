package com.hui.wang.spring.cloud.trace.api.zuulFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Component;

/**
 * zuul 前置过虑器
 * 设置关联ID
 *
 * @author hui.wang09
 * @since 19 November 2018
 */
@Component
public class TrackingFilter extends ZuulFilter{

	private final Logger LOGGER = Logger.getLogger(TrackingFilter.class);

	private static final int FILTER_ORDER = 1;
	private static final boolean SHOULD_FILTER = true;
	private static final String FILTER_TYPE = "pre";

	/**
	 * filter类型，前置过虑器，后置过虑器和路由过虑器
	 */
	@Override
	public String filterType() {
		return FILTER_TYPE;
	}

	/**
	 * 返回一个整数值，表示filter执行顺序
	 */
	@Override
	public int filterOrder() {
		return FILTER_ORDER;
	}

	/**
	 * 返回一个boolean，表示该过虑器是否执行
	 */
	@Override
	public boolean shouldFilter() {
		return SHOULD_FILTER;
	}

	/**
	 * 每次filter执行的代码
	 */
	@Override
	public Object run() {
		if (StringUtils.isEmpty(FilterUtils.getTraceId())) {
			FilterUtils.setTraceId();
		}

		RequestContext requestContext = RequestContext.getCurrentContext();
		String URL = requestContext.getRequest().getRequestURL().toString();
		String traceId = FilterUtils.getTraceId();
		LOGGER.info("======================================");
		LOGGER.info("request url = " + URL + ", traceId = " + traceId);
		LOGGER.info("======================================");
		return null;
	}
}
