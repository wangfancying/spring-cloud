package com.hui.wang.spring.cloud.controller;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用注解@Value读取配置文件中的值
 *
 * @author hui.wang09
 * @since 13 November 2018
 */
@RestController
@RefreshScope
public class ConfigController {

	private final Logger logger = Logger.getLogger(ConfigController.class);

	@Value("${name}")
	private String name;

	@RequestMapping("/hello")
	public String hello() {
		return "hello, " + name;
	}

}
