package com.hui.wang.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 *
 * @author hui.wang09
 * @since 15 November 2018
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
public class ProviderApplicatioin {

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplicatioin.class, args);
	}
}
