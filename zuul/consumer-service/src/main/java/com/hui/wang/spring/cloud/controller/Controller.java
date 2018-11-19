package com.hui.wang.spring.cloud.controller;

import java.util.Map;

import com.google.common.collect.Maps;
import com.hui.wang.spring.cloud.trace.api.context.TraceContext;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
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
	 * GET请求传参数1
	 */
	@RequestMapping("/consumer/v1")
	public String consumerV1() {
		LOGGER.info("=================================");
		LOGGER.info("traceId = " + TraceContext.getTraceContext().getTraceId());
		LOGGER.info("=================================");
		return restTemplate.getForEntity("http://zuul-server/api/provider?request={1}", String.class, "test").getBody();
	}

	/**
	 * GET请求传参数2
	 */
	@RequestMapping("/consumer/v2")
	public String consumerV2() {
		Map<String, String> map = Maps.newHashMap();
		map.put("request", "test");
		return restTemplate.getForEntity("http://provider-server/provider?request={request}", String.class, map).getBody();
	}
}