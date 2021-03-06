package com.wiley.wpng.ref.lti;

import com.wiley.wpng.ref.common.User;
import com.wiley.wpng.ref.common.UserService;
import com.wiley.wpng.ref.common.com.wiley.wpng.ref.common.entity.LtiConsumer;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LTILaunchController implements InitializingBean {
    private static Log log = LogFactory.getLog(LTILaunchController.class);

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RestClient restClient;

    @Autowired
    private KeyPairService keyPairService;

    @Autowired
    private UserService userService;

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
    public String launch(@RequestParam(name="oauth_consumer_key", required=false, defaultValue="1234") String consumerKey,
                           @RequestParam(name="user_id", required=false, defaultValue="jdoe") String userId,
                         @RequestParam(name="custom_canvas_id", required=false, defaultValue="myccid") String canvasUserId,
                           Model model) throws Exception {

        log.info("Handling Request");
        // The first step is to get the LtiConsumer information
        LtiConsumer ltiConsumer = restClient.getLtiConsumer(consumerKey);

        // The second step is to get the wiley id associated
        // with the user_id/oauth_consumer_key combination
            User user = restClient.getUser(userId, canvasUserId, ltiConsumer.getInstitutionId());

       // User user = userService.getUser(userId, consumerKey);


        if (user == null) {
            // if the user was not found, first check to see if the licencing options on this course allows the user to
            // remain anonymous.  This will affect the the users options during the user provioning step
            // TODO call to Course API
            return "user_provision";

        } else {
            // if the user was found, check to see if user is provisioned for course
            // if not provisioned go to course provisioning step
            // TODO we will implement this later

        }

        // Once we are done with the user, lets generate JWT for the wiley id obtained
        // in the previous steps
        String jwt = jwtService.issueJwtForUser(Integer.toString(user.getId()));
        log.info("Generated jwt: " + jwt);




        model.addAttribute("name", user.getFirstName() + " " + user.getLastName());
        model.addAttribute("token", jwt);
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
