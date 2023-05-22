package com.argentina.dolar.api;

import static java.util.Arrays.asList;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.web.cors.CorsConfiguration.ALL;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class JavaArgentinaDolarApiApplication extends WebSecurityConfigurerAdapter {

  public static void main(String[] args) {
    SpringApplication.run(JavaArgentinaDolarApiApplication.class, args);
  }

  @Value("${spring.application.name}")
  private String applicationName;

  @Value("${spring.application.version}")
  private String applicationVersion;

  @Value("${spring.application.description}")
  private String applicationDescription;

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(metaInfo()).select()
        .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
        .paths(PathSelectors.any()).build();
  }

  private ApiInfo metaInfo() {
    return new ApiInfo(applicationName, applicationDescription, applicationVersion, "urn:tos",
        ApiInfo.DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
        new ArrayList<>());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
      http.cors().and().csrf().disable();
  }
  
  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
      CorsConfiguration configuration = new CorsConfiguration();
      configuration.setAllowedOrigins(asList(ALL));
      configuration.setAllowedMethods(asList(GET.name(), POST.name()));
      configuration.setAllowedHeaders(asList(ALL));
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", configuration);
      return source;
  }
  
}
