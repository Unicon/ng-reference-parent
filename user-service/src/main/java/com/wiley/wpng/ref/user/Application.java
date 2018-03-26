package com.wiley.wpng.ref.user;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {

            User user = new User();
            user.setFirstName("John");
            user.setLastName("Doe");
            user.setLoginName("jdoe");
            user.setPassword("password");
            user.setStudentId("12345");
            user.setUserRole("student");
            user.setUserType("S");

            repository.save(user);
            // save a couple of customers


            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (User user1 : repository.findAll()) {
                log.info(user1.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            User user1 = repository.findOne(1L);

                   if (user1 != null) {
                        log.info("User found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(user1.toString());
                        log.info("");
                    }

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}
