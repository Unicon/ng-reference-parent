package com.wiley.wpng.ref.lti.jwt;

import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {


    @Value("${jwt.issuer}")
    String issuer;

    @Value("${jwt.audience}")
    String audience;

    // Time till jwt will expire.  Default is 6 hours (360 minutes)
    @Value("${jwt.expire.minutes:360}")
    int defaultJwtExpireMinutes;

    @Value("${jwt.service.expire.minutes:5}")
    private int serviceExpireMinutes;

    @Value("${jwt.service.subject:lti_service}")
    private String serviceSubject;


    @Autowired
    private KeyPairService keyPairService;

    /**
     * Issue JWT with the default expiration
     * @param subject
     * @return
     * @throws JwtException
     */
    public String issueJwtForUser(String subject) throws JwtException {
        return issueJwt(subject, defaultJwtExpireMinutes);

    }

    /**
     * Issue a JWT that will be used by the LTI service
     * for NG API Calls
     * @return
     * @throws JwtException
     */
    public String issueJwtForService() throws JwtException {
        return issueJwt(serviceSubject, serviceExpireMinutes );

    }

    /**
     * Issue JWT with expiration time explicitly passed
     * @param subject
     * @param jwtExpireMinutes
     * @return
     * @throws JwtException
     */

    private String issueJwt(String subject, int jwtExpireMinutes) throws JwtException {

        // Create the Claims, which will be the content of the JWT
        JwtClaims claims = new JwtClaims();
        claims.setIssuer(issuer);  // who creates the token and signs it
        claims.setAudience(audience);
        claims.setExpirationTimeMinutesInTheFuture(jwtExpireMinutes); // time when the token will expire (10 minutes from now)
        claims.setGeneratedJwtId(); // a unique identifier for the token
        claims.setIssuedAtToNow();  // when the token was issued/created (now)
        claims.setNotBeforeMinutesInThePast(2); // time before which the token is not yet valid (2 minutes ago)
        claims.setSubject(subject); // the subject/principal is whom the token is about

        // A JWT is a JWS and/or a JWE with JSON claims as the payload.
        // In this example it is a JWS so we create a JsonWebSignature object.
        JsonWebSignature jws = new JsonWebSignature();

        // The payload of the JWS is JSON content of the JWT Claims
        jws.setPayload(claims.toJson());

        // The JWT is signed using the private key
        jws.setKey(keyPairService.getKeyInfo().getPrivateKeyMap().get("k1")); // TODO Randomize this

        // Set the Key ID (kid) header because it's just the polite thing to do.
        // We only have one key in this example but a using a Key ID helps
        // facilitate a smooth key rollover process
        jws.setKeyIdHeaderValue("k1"); // TODO Randomize this

        // Set the signature algorithm on the JWT/JWS that will integrity protect the claims
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

        // Sign the JWS and produce the compact serialization or the complete JWT/JWS
        // representation, which is a string consisting of three dot ('.') separated
        // base64url-encoded parts in the form Header.Payload.Signature
        // If you wanted to encrypt it, you can simply set this jwt as the payload
        // of a JsonWebEncryption object and set the cty (Content Type) header to "jwt".
        //String jwt = jws.getCompactSerialization();
        try {
            return jws.getCompactSerialization();
        } catch (JoseException e) {
            throw new JwtException(e.getMessage());
        }


    }
}
