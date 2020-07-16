package com.online.shopping.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket onlineShoppingAPI() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.online.shopping"))
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.apiInfo(myAPIInfo());
		
		
	}

	private ApiInfo myAPIInfo() {
		ApiInfo myAPIInfo = new ApiInfo(
				"MOZELI API",
				"Apache 2.0",
				"",
				"",
				new Contact(
						"Moses Kamira Talemwa",
						"https://github.com/moseskamira/OnlineShoppingSystem",
						"moses.african@gmail.com"),
				"",
				""
				);
		
		// TODO Auto-generated method stub
		return myAPIInfo;
	}
	

}
