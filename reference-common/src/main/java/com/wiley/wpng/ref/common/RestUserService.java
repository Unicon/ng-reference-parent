package com.wiley.wpng.ref.common;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RestUserService implements UserService {
    private Log log = LogFactory.getLog(RestUserService.class);


    private UserRepository userRepository;
    public User getUser(String ltiUserId, String consumerKey) {

        log.info("Handling Request");
        // The first step is to get the wiley id associated
        // with the user_id/oauth_consumer_key combination
//        Map<String, String> parms = new HashMap<>();
//        parms.put("userId", userId);
//        parms.put("consumerKey", consumerKey);
//
//        User user = restTemplate.getForObject("https://localhost:8446/user/{userId/consumer/{consumerKey}", User.class, parms);

        return userRepository.findByLoginName("lfeng");
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
