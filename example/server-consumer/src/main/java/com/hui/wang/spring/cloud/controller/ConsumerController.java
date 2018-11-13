package com.hui.wang.spring.cloud.controller;

import com.hui.wang.spring.cloud.context.holder.UserContextHolder;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author hui.wang09
 * @since 17 十月 2018
 */
@RestController
public class ConsumerController {

	private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	@HystrixCommand(
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "21000")
			},
			fallbackMethod = "error",
			threadPoolKey = "consumerControllerThreadPool",
			threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "30"),
					@HystrixProperty(name = "maxQueueSize", value = "10")
			}
	)
	public String consumer() {
		logger.info("测试TheadContext, user = {}", UserContextHolder.getContext());
		return restTemplate.getForEntity("http://spring-server/hello", String.class).getBody();
	}

	@RequestMapping("/index")
	public String index() {
		return "this";
	}

	public String error() {
		return "error";
	}
}
