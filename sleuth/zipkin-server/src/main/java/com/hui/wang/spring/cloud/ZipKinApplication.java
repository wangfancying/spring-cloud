package com.hui.wang.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 *
 * @author hui.wang09
 * @since 22 November 2018
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinStreamServer
public class ZipKinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipKinApplication.class, args);
	}
}
