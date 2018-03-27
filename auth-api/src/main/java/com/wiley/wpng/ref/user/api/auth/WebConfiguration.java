package com.wiley.wpng.ref.user.api.auth;

import com.wiley.wpng.ref.common.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

    @Bean
    UserRepository userRepository() {
        return new UserRepository();
    }
}
