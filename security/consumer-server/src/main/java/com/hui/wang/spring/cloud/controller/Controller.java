package com.hui.wang.spring.cloud.controller;

import java.util.Map;

import com.google.common.collect.Maps;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hui.wang09
 * @since 15 November 2018
 */
@RestController
public class Controller {

	private final Logger LOGGER = Logger.getLogger(Controller.class);

	@Autowired
	private OAuth2RestTemplate oAuth2RestTemplate;

	/**
	 * GET请求传参数1
	 */
	@RequestMapping("/consumer/v1")
	public String consumerV1() {
		ResponseEntity<String> entity = oAuth2RestTemplate.exchange("http://zuul-server:8822/api/provider?request={1}", HttpMethod.GET, null, String.class, "test");
		return entity.getBody();
	}

	/**
	 * GET请求传参数2
	 */
	@RequestMapping("/consumer/v2")
	public String consumerV2() {
		Map<String, String> map = Maps.newHashMap();
		map.put("request", "test");
		return oAuth2RestTemplate.getForEntity("http://localhost:8822/api/provider?request={request}", String.class, map).getBody();
	}

	@RequestMapping("/consumer/v3")
	public String consumerV3(){
		return "yes";
	}
}