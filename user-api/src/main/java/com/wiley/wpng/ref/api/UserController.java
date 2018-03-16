package com.wiley.wpng.ref.api;

import com.wiley.wpng.ref.api.auth.InvalidAuthException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {

    private static Log log = LogFactory.getLog(UserController.class);



    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "https://localhost:8443")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public User userGet(@PathVariable String userId, @RequestHeader("Authorization") String token) {
        log.debug("Getting user: " + userId + " token: " + token);
        User user = new User();
        user.setUserId(userId);
        user.setFirstName("Parker");
        user.setLastName("Neff");
        return user;

    }
    @RequestMapping(value = "/user/{lmsId}/inst/{instId}", method = RequestMethod.GET)
    public User lmsUserGet(@PathVariable String lmsId, @PathVariable String instId) {
        User user = new User();
        user.setUserId("pneff@unicon.net");
        user.setLmsId(lmsId);
        user.setInstId(instId);
        user.setFirstName("Parker");
        user.setLastName("Neff");
        return user;

    }

    @RequestMapping(value = "/user/auth", method = RequestMethod.POST)
    AuthenticationResponse auth(@RequestParam String userId, @RequestParam String password) {
        log.debug("Authenticating user: " + userId + "/" + password);
        if ("password".equals(password)) {
            Map<String, Object> attrs = new HashMap<>();
            attrs.put("firstName", "Parker");
            attrs.put("lastName", "Neff");
            ArrayList<String> roles = new ArrayList<>();
            roles.add("student");
            roles.add("instructor");
            attrs.put("roles",roles);
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setId(userId);
            authenticationResponse.setAttributes(attrs);

            return authenticationResponse;
        } else {
            throw new InvalidAuthException();

        }



    }
}
