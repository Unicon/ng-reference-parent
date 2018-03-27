package com.wiley.wpng.ref.common.user.api.auth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner demo(UserAuthRepository repository) {



        return (args) -> {
            // save a couple of user
            repository.save(new UserAuth(new Long(1), "jdoe", "secret"));

            repository.save(new UserAuth(new Long(2), "jworth", "secret"));

            repository.save(new UserAuth(new Long(3), "parker", "password"));

        };
    }


}
