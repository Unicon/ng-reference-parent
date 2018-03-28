package com.wiley.wpng.ref.lti.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JwtKeyConfiguration {
  //  @Value("${keystore.file}") String keystoreFile;
  //  @Value("${keystore.password}") String keystorePassword;

//    @Bean
//    public KeyInfo keyInfo() {
//        KeyPairService keyPairService = new KeyPairService();
//        keyPairService.setKeyStorePassword(keystorePassword);
//        keyPairService.setKeyStoreFile(keystoreFile);
//        return keyPairService.getKeyInfo();
//
//    }

    @Bean
    public KeyPairService keyPairService() {
        return new KeyPairService();
    }

    @Bean
    public JwtService jwtService() {
        return new JwtService();
    }


}




