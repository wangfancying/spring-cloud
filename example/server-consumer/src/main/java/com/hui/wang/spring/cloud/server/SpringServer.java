package com.hui.wang.spring.cloud.server;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO completion javadoc.
 *
 * @author hui.wang09
 * @since 17 十月 2018
 */
//@FeignClient(name = "SpringServer")
public interface SpringServer {

	@RequestMapping(value = "/")
	String springServerIndex();
}
