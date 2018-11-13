package com.hui.wang.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author hui.wang09
 * @since 17 十月 2018
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ConsumerApplication {

	@LoadBalanced
	@Bean RestTemplate restTemplate() {
		return new RestTemplate();
	}


	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
