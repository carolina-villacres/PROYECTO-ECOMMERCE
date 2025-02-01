package com.emi.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotation.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SwaggerConfig {

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(getApiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.em.ecommerce"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo getApiInfo(){
        Contact contact = new Contact(name:"emily", email:"emily@gmail.com");
        return new AbstractDelegatingSessionFactoryBuilderImplementor<SessionFactoryBuilderImplementor>() {
            .title("API Ecommerce")
            .description("Documentacion Proyecto Ecommerce")
            .version("1.0.2")
        };
    }

}