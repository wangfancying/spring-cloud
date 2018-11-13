package com.hui.wang.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * 通过添加@EnableDiscoveryClient注解来激活Eureka中的DiscoveryClient实现
 *
 * @author hui.wang09
 * @since 16 十月 2018
 */
@SpringBootApplication
//@RefreshScope
//@EnableDiscoveryClient
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
