package com.hui.wang.spring.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

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

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private DefaultTokenServices tokenServices;

	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("security")
				.secret("hui")
				.authorizedGrantTypes("refresh_token", "password", "client_credentials")
				.scopes("webclient", "mobileclient");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
				.tokenStore(tokenStore)
				.accessTokenConverter(jwtAccessTokenConverter)
				.authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService);
	}
}
