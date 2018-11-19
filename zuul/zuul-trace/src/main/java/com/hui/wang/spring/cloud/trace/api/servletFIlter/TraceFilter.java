package com.hui.wang.spring.cloud.trace.api.servletFIlter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.hui.wang.spring.cloud.trace.api.context.TraceContext;
import com.hui.wang.spring.cloud.trace.api.model.Trace;
import com.hui.wang.spring.cloud.trace.api.zuulFilter.FilterUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author hui.wang09
 * @since 19 November 2018
 */
public class TraceFilter implements Filter{

	private static final Logger LOGGER = LoggerFactory.getLogger(TraceFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		try {
			try {
				HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
				if (StringUtils.isNotEmpty(httpServletRequest.getHeader(FilterUtils.TRACE_ID))) {
					Trace trace = new Trace();
					trace.setTraceId(httpServletRequest.getHeader(FilterUtils.TRACE_ID));
					trace.setCreateTime(new Date());
					TraceContext.setTraceContext(trace);
					LOGGER.info("filter set trace success");
				}
			} catch (Exception e) {
				LOGGER.error("filter set trace error", e);
			}
			filterChain.doFilter(servletRequest, servletResponse);
		} finally {
			TraceContext.clean();
		}
	}

	@Override
	public void destroy() {

	}
}
