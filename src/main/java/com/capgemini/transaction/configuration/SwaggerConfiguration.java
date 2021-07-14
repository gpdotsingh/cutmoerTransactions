package com.capgemini.transaction.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class is responsible to generate swagger configuration
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket bookHotelApi() {
        return new Docket( DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.capgemini.transaction.controller"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Transaction details")
                .version("1.0")
                .description("Application responsible for maintaining transactions..")
                .build();
    }
}
