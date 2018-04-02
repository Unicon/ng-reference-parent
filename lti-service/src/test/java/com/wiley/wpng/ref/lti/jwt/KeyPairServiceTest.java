package com.wiley.wpng.ref.lti.jwt;

import com.wiley.wpng.ref.lti.Application;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jose4j.jwk.JsonWebKeySet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Test the generation and validation of a JWT
 *
 * @author Parker Neff
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)

public class KeyPairServiceTest {

    private static Log LOGGER = LogFactory.getLog(KeyPairServiceTest.class);

    @Autowired
    private KeyPairService keyPairService;




    @Test
    public void testValidJwk() throws Exception {
        assertNotNull(keyPairService);

        JsonWebKeySet jwks = keyPairService.getKeyInfo().getJsonWebKeySet();
        LOGGER.info("jwks set");
        LOGGER.info(jwks.toJson());




    }
}
