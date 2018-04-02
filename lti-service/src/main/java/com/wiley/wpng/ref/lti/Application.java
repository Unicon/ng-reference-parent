package com.wiley.wpng.ref.lti;

import com.wiley.wpng.ref.common.InMemoryUserService;
import com.wiley.wpng.ref.lti.com.wiley.wpng.ref.lti.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        restTemplate.setInterceptors(Collections.singletonList(new BearerTokenInterceptor()));

        return restTemplate;
    }

    @Bean
    public UserService userService() {
        return new InMemoryUserService();
    }
}
