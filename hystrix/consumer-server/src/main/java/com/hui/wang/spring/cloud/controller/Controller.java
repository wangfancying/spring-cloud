package com.hui.wang.spring.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 对hystrix简单的使用
 *
 * @author hui.wang09
 * @since 15 November 2018
 */
@RestController
public class Controller {

	private final Logger LOGGER = Logger.getLogger(Controller.class);

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 简单使用hystrix的熔断器模式
	 * 使用注解@HystrixCommand，默认超时时间为1000ms，超时将快速失败
	 */
	@HystrixCommand
	@RequestMapping("/consumer/v1")
	public String consumerV1() {
		return restTemplate.getForEntity("http://provider-server/provider?request={1}", String.class, "test").getBody();
	}


	/**
	 * 定制熔断器的超时时间
	 * 通过commandProperties属性定制熔断器的行为
	 * 这里将熔断器超时时间设为12000ms
	 */
	@HystrixCommand(
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.threadlocal.timeoutInMilliseconds", value = "120000")
			}
	)
	@RequestMapping("/consumer/v2")
	public String consumerV2() {
		return restTemplate.getForEntity("http://provider-server/provider?request={1}", String.class, "test").getBody();
	}



	/**
	 * 简单使用hystrix的后备模式
	 * 在@HystrixCommand指定fallbackMethod值，就可以在调用失败后，调用fallbackMethod指定的方法了
	 */
	@HystrixCommand(fallbackMethod = "fallback")
	@RequestMapping("/consumer/v3")
	public String consumerV3() {
		return restTemplate.getForEntity("http://provider-server/provider?request={1}", String.class, "test").getBody();
	}

	private String fallback() {
		return "invoke error";
	}


	/**
	 * 简单使用hystrix的舱壁模式
	 * Hystrix使用threadPoolKey属性值搭建一个线程池，
	 * 并使用threadPoolProperties中的属性值对线程池配置
	 */
	@HystrixCommand(fallbackMethod = "fallback",
			threadPoolKey = "consumer-v4",
			threadPoolProperties = {
				@HystrixProperty(name = "coreSize", value = "30"),
				@HystrixProperty(name = "maxQueueSize", value = "10")
			}
	)
	@RequestMapping("/consumer/v4")
	public String consumerV4() {
		return restTemplate.getForEntity("http://provider-server/provider?request={1}", String.class, "test").getBody();
	}
}
