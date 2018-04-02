package com.wiley.wpng.ref.common;

import com.wiley.wpng.ref.lti.com.wiley.wpng.ref.lti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class InMemoryUserService implements UserService {

    @Autowired
    private UserRepository userRepository;
    public User getUser(String ltiUserId, String consumerKey) {
        return userRepository.findByLoginName("lfeng");
    }
}
