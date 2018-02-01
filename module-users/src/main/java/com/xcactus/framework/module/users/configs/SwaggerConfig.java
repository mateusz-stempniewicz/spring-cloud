/**
 * 
 */
package com.xcactus.framework.module.users.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author mateusz.stempniewicz
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket userApi() {
		return new Docket(DocumentationType.SWAGGER_2)
		    .apiInfo(apiInfo())
		    .ignoredParameterTypes(ApiIgnore.class)
		    .tags(new Tag("users", "Users API"))
		    .select()
		    .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
		    .paths(PathSelectors.ant("/*"))
		    .build();
	}
	
	@Bean
	public ApiInfo apiInfo() {
		Contact contact = new Contact("Mateusz Stempniewicz", "xcactus.com",
		    "mateusz.stempniewicz@xcactus.pl");
		return new ApiInfoBuilder()
		    .title("Module Users")
		    .description("Xcactus Framework Module Users - Rest Api")
		    .version("0.1.0")
		    .contact(contact)
		    .build();
	}
	
	@Bean
	public UiConfiguration uiConfiguration() {
		return new UiConfiguration(null);
	}
	
}
