package com.wiley.wpng.ref.lti;

import com.wiley.wpng.ref.common.User;
import com.wiley.wpng.ref.lti.jwt.JwtService;
import com.wiley.wpng.ref.lti.jwt.KeyPairService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Controller
public class LTILaunchController implements InitializingBean {
    private static Log log = LogFactory.getLog(LTILaunchController.class);

    @Autowired
    private JwtService jwtService;

    @Autowired
    private KeyPairService keyPairService;

    @Autowired
    RestTemplate restTemplate;

    private String jwksJson = null;


    /**
     * This is an example LTI Launch demonstrating calling the NG APIs and generating
     * a JWT for the student or instructor who started the launch
     * It assumes that OAUTH validation of the LTI consumer has already been completed
     * @param consumerKey
     * @param userId
     * @param model
     * @return
     */
    @PostMapping("/launch")
    public String greeting(@RequestParam(name="oauth_consumer_key", required=false, defaultValue="1234") String consumerKey,
                           @RequestParam(name="user_id", required=false, defaultValue="jdoe") String userId,
                           Model model) {

        log.info("Handling Request");
        // The first step is to get the wiley id associated
        // with the user_id/oauth_consumer_key combination
        Map<String, String> parms = new HashMap<>();
        parms.put("userId", userId);
        parms.put("consumerKey", consumerKey);

        User user = restTemplate.getForObject("https://localhost:8446/user/{userId/consumer/{consumerKey}", User.class, parms);


        if (user == null) {
            // if the user was not found, first check to see if the licencing options on this course allows the user to
            // remain anonymous.  This will affect the the users options during the user provioning step
            // TODO call to Course API
            return "user_provision";

        } else {
            // if the user was found, check to see if user is provisioned for course
            // if not provisioned go to course provisioning step

        }

        // The second step is to generate a JWT for the wiley id obtained
        // in the previous step



        model.addAttribute("name", "hello");
        return "tool";
    }


    /**
     * Returns the JSON Web Key set public keys used when issuing a JWT
     * so downstream services can validate JWTs issued from this service
     * @return JSON
     */
    @RequestMapping(value = "/oidc/jwks", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> jwks() {

        return new ResponseEntity(jwksJson, HttpStatus.OK);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        jwksJson = keyPairService.getKeyInfo().getJsonWebKeySet().toJson();
        log.info("Initialized jwksJSON with: " + jwksJson);

    }
}
