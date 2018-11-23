package com.hui.wang.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author hui.wang09
 * @since 15 November 2018
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplicatioin {

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplicatioin.class, args);
	}
}
