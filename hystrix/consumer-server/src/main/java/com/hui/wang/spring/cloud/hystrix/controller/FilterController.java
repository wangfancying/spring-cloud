package com.hui.wang.spring.cloud.hystrix.controller;

import com.hui.wang.spring.cloud.context.UserContext;
import com.hui.wang.spring.cloud.context.UserInfo;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 测试filter
 * @see com.hui.wang.spring.cloud.filter.UserContextFilter
 *
 * @author hui.wang09
 * @since 18 November 2018
 */
@RestController
public class FilterController {

	private final Logger LOGGER = Logger.getLogger(FilterController.class);

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/userFilter/v1")
	public UserInfo userFilter() {
		UserInfo userInfo = UserContext.getUserInfo();
		return userInfo;
	}
}
