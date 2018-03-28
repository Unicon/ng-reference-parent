package com.wiley.wpng.ref.lti.jwt;

import com.wiley.wpng.ref.lti.Application;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.NumericDate;
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

public class JwtServiceTest {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private KeyPairService keyPairService;



    @Value("${jwt.issuer}") String issuer;

    @Value("${jwt.audience}") String audience;


    // Time till jwt will expire.  Default is 6 hours (360 minutes)
    @Value("${jwt.expire.minutes:360}")
    int defaultJwtExpireMinutes;

    public static final String SUBJECT = "jdoe";


    @Test
    public void generateJwtDefaultExpire()   {
        assertNotNull(jwtService);
        String subject = "jdoe";
        try {
            String jwt = jwtService.issueJwt(subject);
            assertNotNull(jwt);
            System.out.println("JWT:");
            System.out.println(jwt);

            JwtClaims claims = validateJwt(jwt);
            assertNotNull(claims);

            assertEquals(subject, claims.getSubject() );
            assertEquals(issuer, claims.getIssuer());
            assertEquals(audience, claims.getAudience().get(0));
            assertEquals(defaultJwtExpireMinutes,(claims.getExpirationTime().getValueInMillis() - claims.getIssuedAt().getValueInMillis()) / 60000);

          //  assertEquals(defaultJwtExpireMinutes, expireMin);
           // NumericDate numericDate = claims.getExpirationTime();
          //  System.out.println("nueric: " + numericDate.toString());



        } catch (Exception e) {
            fail(e.getMessage());
        }


    }

    @Test
    public void generateJwt()   {
        assertNotNull(jwtService);
        String subject = "jdoe";
        int expireMin = 30;
        try {
            String jwt = jwtService.issueJwt(subject, expireMin);
            assertNotNull(jwt);
            System.out.println("JWT:");
            System.out.println(jwt);

            JwtClaims claims = validateJwt(jwt);
            assertNotNull(claims);

            assertEquals(subject, claims.getSubject() );
            assertEquals(issuer, claims.getIssuer());
            assertEquals(audience, claims.getAudience().get(0));
            assertEquals(expireMin,(claims.getExpirationTime().getValueInMillis() - claims.getIssuedAt().getValueInMillis()) / 60000);



        } catch (Exception e) {
            fail(e.getMessage());
        }


    }

    private JwtClaims validateJwt(String jwt) throws Exception {


        JsonWebKey key = keyPairService.getKeyInfo().getJsonWebKeySet().findJsonWebKey("k1", "RSA", null, null);

        assertNotNull(key);

        JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                .setRequireExpirationTime() // the JWT must have an expiration time
                .setAllowedClockSkewInSeconds(30) // allow some leeway in validating time based claims to account for clock skew
                .setRequireSubject() // the JWT must have a subject claim
                .setSkipDefaultAudienceValidation() // TODO Determine if audience check really is required
                //.setExpectedAudience(false, "tiOFA1XX0w6g4exs1FQVEBkcCTcr7zEu") // to whom the JWT is intended for
                .setVerificationKey(key.getKey())
                .build(); // create the JwtConsumer instance



            return jwtConsumer.processToClaims(jwt);

    }
}
