package com.hui.wang.spring.cloud;

import java.util.Map;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author hui.wang09
 * @since 18 November 2018
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(Sink.class)
public class ConsumerApplication {

	private final Logger LOGGER = Logger.getLogger(ConsumerApplication.class);

	@StreamListener(Sink.INPUT)
	public void sink(Map<String, Object> map) {
		LOGGER.info("=======================");
		LOGGER.info(map);
		LOGGER.info("=======================");
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		RestTemplate template = new RestTemplate();
		return template;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
