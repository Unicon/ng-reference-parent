package com.wiley.wpng.ref.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InMemoryUserService implements UserService {



    private UserRepository userRepository;
    public User getUser(String ltiUserId, String consumerKey) {
        return userRepository.findByLoginName("lfeng");
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
