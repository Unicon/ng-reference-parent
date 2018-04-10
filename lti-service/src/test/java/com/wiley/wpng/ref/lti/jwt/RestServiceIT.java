package com.wiley.wpng.ref.lti.jwt;

import com.wiley.wpng.ref.common.User;
import com.wiley.wpng.ref.lti.Application;
import com.wiley.wpng.ref.lti.RestClient;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


/**
 * Test the generation and validation of a JWT
 *
 * @author Parker Neff
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)

public class RestServiceIT {

    @Autowired
    private RestClient restClient;




    @Test
    public void callApi()   {
        User user = restClient.getUser("111", "3456", "1234");
        assertNotNull(user);

    }
}
