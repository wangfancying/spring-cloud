package com.hui.wang.spring.cloud.controller;


import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hui.wang09
 * @since 16 十月 2018
 */
@RestController
//@RefreshScope
public class ConfigController {

	private final Logger logger = Logger.getLogger(ConfigController.class);

	@Value("${name}")
	private String name;

	@RequestMapping("/hello")
	public String hello() throws InterruptedException {
		return "hello, " + name;
	}
}
