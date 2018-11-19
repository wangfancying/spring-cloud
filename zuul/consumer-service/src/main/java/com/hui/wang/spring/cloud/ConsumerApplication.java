package com.hui.wang.spring.cloud;

import java.util.List;
import java.util.Objects;

import com.google.common.collect.Lists;
import com.hui.wang.spring.cloud.trace.api.interceptor.TraceInterceptor;
import com.hui.wang.spring.cloud.trace.api.servletFIlter.TraceFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author hui.wang09
 * @since 18 November 2018
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		RestTemplate template = new RestTemplate();
		List interceptors = template.getInterceptors();
		if (Objects.isNull(interceptors)) {
			template.setInterceptors(Lists.newArrayList(new TraceInterceptor()));
		} else {
			interceptors.add(new TraceInterceptor());
			template.setInterceptors(interceptors);
		}
		return template;
	}

	@Bean
	public TraceFilter traceFilter() {
		return new TraceFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
