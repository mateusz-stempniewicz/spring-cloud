/**
 * 
 */
package com.xcactus.zuul.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author mateusz.stempniewicz
 *
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
	
}
