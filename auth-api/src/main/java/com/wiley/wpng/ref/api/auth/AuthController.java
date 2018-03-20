package com.wiley.wpng.ref.api.auth;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AuthController {

    public static final int INVALID_LOGIN_ATTEMPTS = 3;

    private static Log log = LogFactory.getLog(AuthController.class);

    @Autowired
    private ContrivedUserService userService;


    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    ResponseEntity<?> auth(@RequestParam(value="login_name") String loginName, @RequestParam(value="password") String password) {

       // HttpStatus.LOCKED

        log.debug("Authenticating user  " + loginName);

        User user = userService.getUserByLoginId(loginName);

       if (user == null) {
           return new ResponseEntity(HttpStatus.NOT_FOUND);

       } else {
           if (user.getDisabled()) {
               return new ResponseEntity(HttpStatus.LOCKED);
           }
           if (password != null && password.equalsIgnoreCase(user.getPassword())) {
               return new ResponseEntity<>(user.getWileyId(), HttpStatus.OK);

           } else {
               user.setLoginAttempts(user.getLoginAttempts() + 1);
               if (user.getLoginAttempts() >= INVALID_LOGIN_ATTEMPTS) {
                   user.setDisabled(true);
               }
               userService.putUser(user);
               return new ResponseEntity(HttpStatus.NOT_FOUND);
           }

       }




    }


}
