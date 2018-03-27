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
                                  @RequestParam(value = "login_name", required = false)  String loginName,
                                  @RequestParam(value = "institution_id", required = false) String institutionId,
                                  @RequestParam(value = "name", required = false) String name,
                                  @RequestHeader("Authorization") String token) {
        log.debug("Getting user: " + loginName + " token: " + token);
        User user = userRepository.findByLoginName(loginName);

        if (user == null) {
            log.debug("User Not found, returning " + HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            log.debug("Found user " + user.getId());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }



    }

    @RequestMapping(value = "/user/{lmsId}/inst/{instId}", method = RequestMethod.GET)
    public User lmsUserGet(@PathVariable String lmsId, @PathVariable String instId) {
//            User user = new User();
//            user.setUserId("pneff@unicon.net");
//            user.setLmsId(lmsId);
//            user.setInstId(instId);
//            user.setFirstName("Parker");
//            user.setLastName("Neff");
        return null;

    }


}
