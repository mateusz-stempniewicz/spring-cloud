/**
 * 
 */
package com.xcactus.framework.module.users.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author mateusz.stempniewicz
 *
 */
@EnableAutoConfiguration
@ComponentScan("com.xcactus.framework.module.users")
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.xcactus.framework.module.users")
// @PropertySource(value={"classpath:application.yml"})
public class Application {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
