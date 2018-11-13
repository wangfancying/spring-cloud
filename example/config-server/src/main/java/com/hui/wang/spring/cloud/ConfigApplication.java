package com.hui.wang.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * config 引导类
 * 注解@EnableConfigServer使服务成为spring cloud config服务
 *
 * @author hui.wang09
 * @since 16 十月 2018
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}
}
