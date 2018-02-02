/**
 * 
 */
package com.xcactus.framework.module.users.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * @author mateusz.stempniewicz
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private ClientDetailsService clientDetailsService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	@Lazy
	private JwtUserAuthenticationConverter userAuthenticationConverter;
	
	@Autowired
	private TokenStore tokenStore;
	
	@Value("${app.resource-id}")
	private String resourceId;
	
	@Value("${app.client}")
	private String client;
	
	@Value("${app.client-remember-me}")
	private String clientRememberMe;
	
	@Value("${app.scope}")
	private String scope;
	
	@Value("${app.access-token-validity}")
	private Integer accessTokenValidity;
	
	@Value("${app.refresh-token-validity}")
	private Integer refreshTokenValidity;
	
	@Value("${app.signing-key}")
	private String singingKey;
	
	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		DefaultAccessTokenConverter defaultAccessTokenConverter = new DefaultAccessTokenConverter();
		defaultAccessTokenConverter.setUserTokenConverter(userAuthenticationConverter);
		
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setAccessTokenConverter(defaultAccessTokenConverter);
		accessTokenConverter.setSigningKey(singingKey);
		return accessTokenConverter;
	}
	
	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices tokenServices = new DefaultTokenServices();
		tokenServices.setTokenStore(tokenStore());
		tokenServices.setTokenEnhancer(accessTokenConverter());
		tokenServices.setClientDetailsService(clientDetailsService);
		tokenServices.setSupportRefreshToken(true);
		tokenServices.setReuseRefreshToken(false);
		return tokenServices;
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
		    .userDetailsService(userDetailsService)
		    .reuseRefreshTokens(false)
		    .tokenServices(tokenServices());
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
		    .inMemory()
		    .withClient(client)
		    .resourceIds(resourceId)
		    .authorizedGrantTypes("password", "refresh_token")
		    .scopes(scope)
		    .autoApprove(scope)
		    .accessTokenValiditySeconds(accessTokenValidity)
		    .refreshTokenValiditySeconds(refreshTokenValidity)
		    .and()
		    .withClient(clientRememberMe)
		    .resourceIds(resourceId)
		    .authorizedGrantTypes("password", "refresh_token")
		    .scopes(scope)
		    .autoApprove(scope)
		    .accessTokenValiditySeconds(0)
		    .refreshTokenValiditySeconds(0);
	}
	
}
