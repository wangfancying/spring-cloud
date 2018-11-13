package com.hui.wang.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 *
 * @author hui.wang09
 * @since 13 November 2018
 */
@SpringBootApplication
@RefreshScope
public class ConfigClient {
	public static void main(String[] args) {
		SpringApplication.run(ConfigClient.class, args);
	}
}
