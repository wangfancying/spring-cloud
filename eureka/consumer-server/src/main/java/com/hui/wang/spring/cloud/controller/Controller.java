package com.hui.wang.spring.cloud.controller;

import java.net.URI;
import java.util.Map;

import com.google.common.collect.Maps;
import com.hui.wang.spring.cloud.api.model.ReqBody;
import com.hui.wang.spring.cloud.api.model.RespBody;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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
		return restTemplate.getForEntity("http://provider-server/provider?request={1}", String.class, "test").getBody();
	}

	/**
	 * GET请求传参数2
	 */
	@RequestMapping("/consumer/v2")
	public String consumerV2() {
		Map<String, String> map = Maps.newHashMap();
		map.put("request","test");
		return restTemplate.getForEntity("http://provider-server/provider?request={request}", String.class, map).getBody();
	}


	/**
	 * 使用UriComponents构建get请求参数
	 */
	@RequestMapping(value = "/consumer/v3")
	public String consumerV3() {
		UriComponents uriComponents = UriComponentsBuilder
				.fromUriString("http://provider-server/provider?request={request}")
				.build()
				.expand("测试")
				.encode();

		URI uri = uriComponents.toUri();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		return responseEntity.getBody();
	}

	/**
	 * post请求
	 */
	@RequestMapping(value = "post")
	public RespBody post() {
		ReqBody reqBody = new ReqBody();
		reqBody.setPassword("hui");
		reqBody.setUsername("wang");

		ResponseEntity<RespBody> respBodyResponseEntity =  restTemplate.postForEntity("http://provider-server/post", reqBody, RespBody.class);
		LOGGER.info("respBodyResponseEntity.status = " + respBodyResponseEntity.getStatusCodeValue());
		return respBodyResponseEntity.getBody();
	}
}
