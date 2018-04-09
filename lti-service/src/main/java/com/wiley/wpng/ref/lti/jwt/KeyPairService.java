package com.wiley.wpng.ref.lti.jwt;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jose4j.jwk.JsonWebKeySet;
import org.jose4j.jwk.PublicJsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.security.*;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;


@Service
public class KeyPairService {
    @Value("${jwt.key-store}")
    private String keyStoreFile;
    @Value("${jwt.key-password}")
    private String keyStorePassword;

    @Autowired
    private ApplicationContext appContext;

    private Log log = LogFactory.getLog(KeyPairService.class);

    public KeyInfo getKeyInfo() {
        Map<String, PrivateKey> privateKeyMap = new LinkedHashMap<>();
        JsonWebKeySet jsonWebKeySet = new JsonWebKeySet();


        try {

            Resource resource = appContext.getResource(keyStoreFile);
            KeyStore keyStore = KeyStore.getInstance("JKS");

            keyStore.load(resource.getInputStream(), keyStorePassword.toCharArray());
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                String alias = aliases.nextElement();
                log.info("key=" + alias);
                try {
                    Key key = keyStore.getKey(alias, "password".toCharArray());
                    if (key instanceof PrivateKey) {
                        Certificate cert = keyStore.getCertificate(alias);
                        PublicKey publicKey = cert.getPublicKey();
                        RsaJsonWebKey rsaJwk = (RsaJsonWebKey) PublicJsonWebKey.Factory.newPublicJwk(publicKey);
                        rsaJwk.setKeyId(alias);
                        jsonWebKeySet.addJsonWebKey(rsaJwk);
                        privateKeyMap.put(alias, (PrivateKey) key);

                    }


                } catch (UnrecoverableKeyException e) {
                    e.printStackTrace();
                }
            }
            return new KeyInfo(jsonWebKeySet, privateKeyMap);
        } catch (Exception e) {
            log.fatal(e.getMessage());

            return null;
        }

    }
}
