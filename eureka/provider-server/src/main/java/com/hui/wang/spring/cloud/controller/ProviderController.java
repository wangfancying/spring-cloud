package com.hui.wang.spring.cloud.controller;


import com.hui.wang.spring.cloud.api.model.ReqBody;
import com.hui.wang.spring.cloud.api.model.RespBody;
import org.apache.log4j.Logger;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hui.wang09
 * @since 15 November 2018
 */
@RestController
public class ProviderController {

	private final Logger LOGGER = Logger.getLogger(ProviderController.class);

	/**
	 * get方式接口
	 * @param request 请求参数
	 */
	@RequestMapping(value = "/provider", method = RequestMethod.GET)
	public String provider(@RequestParam String request) {
		LOGGER.info("========================================");
		LOGGER.info("provider service 被调用");
		LOGGER.info("========================================");
		return "provider, " + request;
	}

	/**
	 * POST方式接口
	 * @param reqBody request body
	 */
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public RespBody post(@RequestBody ReqBody reqBody) {
		RespBody respBody = new RespBody();
		respBody.setRequest(reqBody.getUsername());
		respBody.setResult("yes");
		return respBody;
	}
}
