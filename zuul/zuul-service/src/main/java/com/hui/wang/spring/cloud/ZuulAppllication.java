package com.hui.wang.spring.cloud;

import com.hui.wang.spring.cloud.trace.api.zuulFilter.ResponseFilter;
import com.hui.wang.spring.cloud.trace.api.zuulFilter.TrackingFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author hui.wang09
 * @since 18 November 2018
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulAppllication {

	@Bean
	public TrackingFilter trackingFilter() {
		return new TrackingFilter();
	}

	@Bean
	public ResponseFilter responseFilter() {
		return new ResponseFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ZuulAppllication.class, args);
	}
}
