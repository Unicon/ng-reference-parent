package com.wiley.wpng.ref.user.api;

import com.wiley.wpng.ref.common.User;
import com.wiley.wpng.ref.common.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    private static Log log = LogFactory.getLog(UserController.class);

    @Autowired
    private UserRepository userRepository;


    @CrossOrigin(origins = "https://localhost:8445")
    @RequestMapping(value = "/users/search", method = RequestMethod.GET)
    public ResponseEntity<?> userGet(@RequestParam(value = "role", required = true) String role,
                                     @RequestParam(value = "login_name", required = false) String loginName,
                                     @RequestParam(value = "institution_id", required = false) String institutionId,
                                     @RequestParam(value = "name", required = false) String name,
                                     @RequestParam(value = "lti_user_id", required = false) String ltiUserId,
                                     @RequestParam(value = "canvas_user_id", required = false) String canvasUserId,
                                     @RequestHeader("Authorization") String token) {

        User user = null;
        if (ltiUserId != null) {
            log.debug("gettting user by lmsUserId=" + ltiUserId);
            user = userRepository.findByLmsUserId(ltiUserId);
        } else {
            log.debug("Getting user: " + loginName + " token: " + token);
              user = userRepository.findByLoginName(loginName);
        }

        if (user == null) {
            log.debug("User Not found, returning " + HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {

            log.debug("Found user " + user.getId());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }


    }


    /**
     * Search user.
     * @return - user's data in JSON.
     */
    @RequestMapping(value = "/users/searchz", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity<Object> search(@RequestParam(value = "role") String role,
                                         @RequestParam(required = false, value = "login_name") String loginName,
                                         @RequestParam(required = false, value = "institution_id") Long institutionId,
                                         @RequestParam(required = false, value = "name") String name) {
        // log.debug("Getting user: " + loginName + " token: " + token);
        User user = userRepository.findByLoginName("parker");

        if (user == null) {
            log.debug("User Not found, returning " + HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            log.debug("Found user " + user.getId());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/user/{userId/consumer/{consumerKey}", method = RequestMethod.GET)
    public ResponseEntity<?> lmsUserGet(@PathVariable String userId, @PathVariable String consumerKey, @RequestParam(value = "canvas)id", required = false) String canvasId) {
        if ("bad".equalsIgnoreCase(consumerKey)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            // this is just a bogus call.  It should user the userId and consumerKey for the lookup
            return new ResponseEntity<>(userRepository.findByLoginName("smore"), HttpStatus.OK);

        }

    }


}
