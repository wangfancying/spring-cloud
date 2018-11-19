package com.hui.wang.spring.cloud;

import com.hui.wang.spring.cloud.trace.api.servletFIlter.TraceFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author hui.wang09
 * @since 15 November 2018
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplicatioin {

	@Bean
	public TraceFilter traceFilter() {
		return new TraceFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplicatioin.class, args);
	}
}
