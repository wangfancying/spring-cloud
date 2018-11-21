package com.hui.wang.spring.cloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *
 * @author hui.wang09
 * @since 20 November 2018
 */
@Configuration
@Component
public class KeyServiceConfig {

	@Value("${sign.key}")
	private String jwtSiginKey;

	public String getJwtSiginKey() {
		return jwtSiginKey;
	}
}
