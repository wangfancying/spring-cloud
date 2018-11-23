package com.hui.wang.spring.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 *
 * @author hui.wang09
 * @since 20 November 2018
 */
@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * 定义通过验证服务注册了哪些客户端应用程序
	 * ClientDetailsServiceConfigurer 支持两种不同类型的存储：内存存储和JDBC存储
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("security")
				.secret("hui")		// 注册应用程序的名称和秘钥
				.authorizedGrantTypes("refresh_token", "password", "client_credentials")	// 授权类型，密码，客户端凭证
				.scopes("webclient", "mobileclient");		//客户端操作的范围
	}

	/**
	 * 使用默认的验证管理器和用户详细信息服务
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
				.authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService);
	}
}
