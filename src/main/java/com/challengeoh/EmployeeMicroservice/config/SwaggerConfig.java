package com.challengeoh.EmployeeMicroservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.challengeoh.EmployeeMicroservice.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                ;
    }

    private ApiInfo getApiInfo() {
        @SuppressWarnings("deprecation")
        ApiInfo apiInfo = new ApiInfo(
                "Employee Microservice",
                "Documentation of employee services",
                "API",
                "Terms of services",
                "castilloesteban2009@gmail.com",
                "License of API",
                "API License URL");
        return apiInfo;
    }
}