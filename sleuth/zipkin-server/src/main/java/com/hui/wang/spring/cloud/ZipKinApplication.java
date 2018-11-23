package com.hui.wang.spring.cloud;

import zipkin.server.EnableZipkinServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @author hui.wang09
 * @since 22 November 2018
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ZipKinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipKinApplication.class, args);
	}
}
