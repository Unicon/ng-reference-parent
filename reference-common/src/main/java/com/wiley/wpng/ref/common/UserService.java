package com.wiley.wpng.ref.common;

import com.wiley.wpng.ref.common.User;

public interface UserService {

    public User getUser(String ltiUserId, String consumerKey);
}
