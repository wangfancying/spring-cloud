package com.hui.wang.spring.cloud.controller;


import java.util.Random;

import com.hui.wang.spring.cloud.api.model.ReqBody;
import com.hui.wang.spring.cloud.api.model.RespBody;
import org.apache.log4j.Logger;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hui.wang09
 * @since 15 November 2018
 */
@RestController
public class ProviderController {

	private final Logger LOGGER = Logger.getLogger(ProviderController.class);

	/**
	 * 这里模拟业务操作
	 * 随机生成一个数字，如果是偶数，sleep 11s
	 */
	@RequestMapping(value = "/provider", method = RequestMethod.GET)
	public String provider(@RequestParam String request) {
		Random random = new Random();
		int randomInt = random.nextInt();
		if (randomInt % 2 == 0) {
			sleep();
		}
		LOGGER.info("========================================");
		LOGGER.info("provider service 被调用");
		LOGGER.info("========================================");
		return "provider, " + request;
	}

	private void sleep() {
		try {
			Thread.sleep(11000);
		} catch (InterruptedException e) {
			LOGGER.error(e);
		}
	}
}
