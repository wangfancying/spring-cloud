package com.hui.wang.spring.cloud.trace.api.interceptor;

import java.io.IOException;
import java.util.Objects;

import com.hui.wang.spring.cloud.trace.api.context.TraceContext;
import com.hui.wang.spring.cloud.trace.api.zuulFilter.FilterUtils;
import org.apache.commons.lang.StringUtils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 *
 * @author hui.wang09
 * @since 19 November 2018
 */
public class TraceInterceptor implements ClientHttpRequestInterceptor{

	@Override
	public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
		if (TraceContext.getTraceContext() != null && StringUtils.isNotEmpty(TraceContext.getTraceContext().getTraceId())) {
			HttpHeaders httpHeaders = httpRequest.getHeaders();
			httpHeaders.set(FilterUtils.TRACE_ID, TraceContext.getTraceContext().getTraceId());
		}
		return clientHttpRequestExecution.execute(httpRequest, bytes);
	}
}
