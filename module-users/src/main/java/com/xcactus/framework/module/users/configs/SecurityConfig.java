/**
 * 
 */
package com.xcactus.framework.module.users.configs;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author mateusz.stempniewicz
 *
 */
@Configuration
@EnableDiscoveryClient
@EnableResourceServer
public class SecurityConfig {
	
}
