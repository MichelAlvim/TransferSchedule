package com.teste.cvc.main;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.teste.cvc.controller"))
            .paths(PathSelectors.any())
            .build().apiInfo(apiInfo());
    }   

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("cvc-bank").description("Test CVC")
				.license("Apache License Version 2.0").version("1.0-SNAPSHOT").build();
	}

	/**
	 * @return
	 */
	@Bean
	public SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/v1/*"))
				.build();
	}

	/**
	 * 
	 * 
	 * 
	 * @return
	 */
	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return newArrayList(new SecurityReference("Authorization", authorizationScopes));
	}

	/**
	 * @return
	 */
	@Bean
	public SecurityScheme apiKey() {
		return new ApiKey("Authorization", "api_key", "header");
	}


}
