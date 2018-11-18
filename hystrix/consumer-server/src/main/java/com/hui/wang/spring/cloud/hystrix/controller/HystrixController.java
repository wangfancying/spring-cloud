package com.hui.wang.spring.cloud.hystrix.controller;

import com.hui.wang.spring.cloud.context.UserContext;
import com.hui.wang.spring.cloud.context.UserInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author hui.wang09
 * @since 18 November 2018
 */
@RestController
public class HystrixController {

	private final Logger LOGGER = Logger.getLogger(HystrixController.class);

	@Autowired
	private RestTemplate restTemplate;


	@HystrixCommand(
			threadPoolKey = "hystrix-v1",
			threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "30"),
					@HystrixProperty(name = "maxQueueSize", value = "10")
			}
	)
	@RequestMapping("/hystrix/v1")
	public String hystrixV1() {
		UserInfo userInfo = UserContext.getUserInfo();
		LOGGER.info("=========================");
		LOGGER.info("userInfo = " + userInfo.toString());
		LOGGER.info("=========================");
		return restTemplate.getForEntity("http://provider-server/provider?request={1}", String.class, "test").getBody();
	}
}
