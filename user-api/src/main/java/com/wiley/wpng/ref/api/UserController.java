package com.wiley.wpng.ref.api;

import com.wiley.wpng.ref.api.auth.InvalidAuthException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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




}
