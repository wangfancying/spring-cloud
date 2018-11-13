package com.hui.wang.spring.cloud.context.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.hui.wang.spring.cloud.context.UserContext;
import com.hui.wang.spring.cloud.context.holder.UserContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

/**
 * 自动配置filter
 *
 * @author hui.wang09
 * @since 17 十月 2018
 */
@Component
public class UserContextFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(UserContextFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

		UserContextHolder.getContext().setUserId(httpServletRequest.getHeader(UserContext.USER_ID));
		UserContextHolder.getContext().setAuthToken(httpServletRequest.getHeader(UserContext.AUTH_TOKEN));

		logger.info("==========================filter");
		filterChain.doFilter(httpServletRequest, servletResponse);
	}

	@Override
	public void destroy() {

	}
}
