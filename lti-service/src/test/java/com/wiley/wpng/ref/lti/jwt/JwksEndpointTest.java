package com.wiley.wpng.ref.lti.jwt;

import com.wiley.wpng.ref.lti.Application;
import org.jose4j.jwk.HttpsJwks;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.keys.resolvers.HttpsJwksVerificationKeyResolver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Test the generation and validation of a JWT
 *
 * @author Parker Neff
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class JwksEndpointTest implements InitializingBean {


    @LocalServerPort
    private int port;




    @Autowired
    private TestRestTemplate testRestTemplate;


    @Autowired
    private JwtService jwtService;

    private HttpsJwksVerificationKeyResolver httpsJwksKeyResolver;


    @Value("${jwt.issuer}") String issuer;

    @Value("${jwt.audience}") String audience;




    @Test
    public void testValidJwk() throws Exception {

    // Get the key resolver from the jwks endpoint




        String subject = "jdoe";

        String jwt = jwtService.issueJwtForUser(subject);
        assertNotNull(jwt);

        JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                .setRequireExpirationTime() // the JWT must have an expiration time
                .setAllowedClockSkewInSeconds(30) // allow some leeway in validating time based claims to account for clock skew
                .setRequireSubject() // the JWT must have a subject claim
                .setSkipDefaultAudienceValidation() // TODO Determine if audience check really is required
                //.setExpectedAudience(false, "tiOFA1XX0w6g4exs1FQVEBkcCTcr7zEu") // to whom the JWT is intended for
                .setVerificationKeyResolver(httpsJwksKeyResolver)
                .build(); // create the JwtConsumer instance

            JwtClaims claims = jwtConsumer.processToClaims(jwt);

        assertNotNull(claims);

        assertEquals(subject, claims.getSubject() );
        assertEquals(issuer, claims.getIssuer());
        assertEquals(audience, claims.getAudience().get(0));
        assertEquals(360,(claims.getExpirationTime().getValueInMillis() - claims.getIssuedAt().getValueInMillis()) / 60000);



    }


    @Override
    public void afterPropertiesSet() throws Exception {

        HttpsJwks httpsJkws = new HttpsJwks("https://localhost:" + port + "/oidc/jwks" );
        httpsJwksKeyResolver = new HttpsJwksVerificationKeyResolver(httpsJkws);
        assertNotNull(httpsJwksKeyResolver);

    }



}
