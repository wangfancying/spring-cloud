package com.hui.wang.spring.cloud.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.hui.wang.spring.cloud.context.UserContext;
import com.hui.wang.spring.cloud.context.UserInfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

/**
 * 模拟用户信息filter
 *
 * @author hui.wang09
 * @since 18 November 2018
 */
@Component
public class UserContextFilter implements Filter{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserContextFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// not do
	}

	/**
	 * 实现doFilter方法
	 * 这里将用户信息保存到上下文中，并在请求结束后clear
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		try {
			try {
				HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
				if (StringUtils.isNotEmpty(httpServletRequest.getHeader(UserInfo.USER_ID)) &&
						StringUtils.isNotEmpty(httpServletRequest.getHeader(UserInfo.USER_TOKEN))) {
					UserContext.getUserInfo().setUserId(httpServletRequest.getHeader(UserInfo.USER_ID));
					UserContext.getUserInfo().setUserToken(httpServletRequest.getHeader(UserInfo.USER_TOKEN));
					LOGGER.info("filter set userInfo success");
				}
			} catch (Exception e) {
				LOGGER.error("filter set userInfo error", e);
			}
			filterChain.doFilter(servletRequest, servletResponse);
		} finally {
			UserContext.clean();
		}
	}

	@Override
	public void destroy() {

	}
}
