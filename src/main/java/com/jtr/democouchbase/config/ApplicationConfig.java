package com.jtr.democouchbase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig implements WebMvcConfigurer
{
	
	private static final String TERMS_SERVICE = "http://www.vodafone.es";
	private static final String LICENSE = "falcata@vodafone.es";
	private static final String LICENSE_URL = "http://www.vodafone.es";
	private static final String VERSION = "1.0";
	private static final String TITLE = "demo-couch-base";
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/").setViewName("redirect:/swagger-ui.html");
	}
	
	/**
	 * api
	 * 
	 * @return
	 */
	@Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()
                .apiInfo(apiInfo());
    }
	
	
	/**
	 * apiInfo
	 * @return
	 */
    private ApiInfo apiInfo() 
    {
    	String description = "demo-couch-base";
        
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(description)
                .termsOfServiceUrl(TERMS_SERVICE)
                .license(LICENSE)
                .licenseUrl(LICENSE_URL)
                .version(VERSION)
                .build();
    }
}
