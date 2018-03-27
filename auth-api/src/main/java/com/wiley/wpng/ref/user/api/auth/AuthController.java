package com.wiley.wpng.ref.user.api.auth;


import com.wiley.wpng.ref.common.User;
import com.wiley.wpng.ref.common.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    public static final int INVALID_LOGIN_ATTEMPTS = 3;

    private static Log log = LogFactory.getLog(AuthController.class);

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    ResponseEntity<?> auth(@RequestParam(value="login_name") String loginName, @RequestParam(value="password") String password) {

       // HttpStatus.LOCKED

        log.debug("Authenticating user  " + loginName);

        User user = userRepository.findByLoginName(loginName);

       if (user == null) {
           log.debug("User is null, returning  " + HttpStatus.FORBIDDEN);
           return new ResponseEntity(HttpStatus.FORBIDDEN);

       } else {
           if (user.isDisabled()) {
               log.debug("User disabled returning  " + HttpStatus.LOCKED);
               return new ResponseEntity(HttpStatus.LOCKED);
           }
           if (password != null && password.equalsIgnoreCase(user.getPassword())) {
               log.debug("Valid password, returning  " + HttpStatus.OK);
               user.setLoginAttempts(0);
              // userService.putUser(user);
               return new ResponseEntity<>( HttpStatus.OK);

           } else {
               log.debug("Invalid password, returning  " + HttpStatus.FORBIDDEN);
               user.setLoginAttempts(user.getLoginAttempts() + 1);
               if (user.getLoginAttempts() >= INVALID_LOGIN_ATTEMPTS) {
                  // user.setDisabled(true);
               }
             //  userService.putUser(user);
               return new ResponseEntity(HttpStatus.FORBIDDEN);
           }

       }




    }


}
