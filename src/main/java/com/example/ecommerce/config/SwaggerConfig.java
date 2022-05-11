package com.example.ecommerce.config;

import static springfox.documentation.builders.PathSelectors.regex;

import com.google.common.base.Predicates;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class configures the swagger documentation for the project, which can also be used for
 * manual testing of the endpoints in the controller
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .useDefaultResponseMessages(false)
        .pathMapping("/").enableUrlTemplating(true)
        .select()
        .paths(PathSelectors.any())
        //.paths(regex("[^error]"))
        .build()
        .apiInfo(apiDetails());
  }

  private ApiInfo apiDetails() {
    return new ApiInfo(
        "Ecommerce REST API",
        "Java REST API project for an ecommerce website",
        "1.0",
        "Sample",
        new springfox.documentation.service.Contact("Brandyn Tse",
            "https://www.linkedin.com/in/brandyn-tse-085872166",
            "brandyntse941@gmail.com"),
        "n/a",
        "n/a",
        Collections.emptyList());
  }
}
