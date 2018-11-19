package com.hui.wang.spring.cloud.trace.api.zuulFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO completion javadoc.
 *
 * @author hui.wang09
 * @since 19 November 2018
 */
public class ResponseFilter extends ZuulFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResponseFilter.class);

	private static final int FILTER_ORDER = 1;
	private static final boolean SHOULD_FILTER = true;
	private static final String FILTER_TYPE = "post";

	@Override
	public String filterType() {
		return FILTER_TYPE;
	}

	@Override
	public int filterOrder() {
		return FILTER_ORDER;
	}

	@Override
	public boolean shouldFilter() {
		return SHOULD_FILTER;
	}

	@Override
	public Object run() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		String URL = requestContext.getRequest().getRequestURL().toString();
		LOGGER.info("======================================");
		LOGGER.info("response url " + URL + "traceId = " + FilterUtils.getTraceId());
		LOGGER.info("======================================");
		requestContext.getResponse().addHeader(FilterUtils.TRACE_ID, FilterUtils.getTraceId());
		return null;
	}
}
