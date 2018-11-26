package com.hui.wang.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *
 * @author hui.wang09
 * @since 18 November 2018
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulAppllication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulAppllication.class, args);
	}
}
