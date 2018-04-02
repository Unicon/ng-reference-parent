package com.wiley.wpng.ref.lti.com.wiley.wpng.ref.lti.service;

import com.wiley.wpng.ref.common.User;

public interface UserService {

    public User getUser(String ltiUserId, String consumerKey);
}
