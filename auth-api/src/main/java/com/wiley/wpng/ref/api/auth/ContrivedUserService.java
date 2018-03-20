package com.wiley.wpng.ref.api.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class ContrivedUserService {

    public static final String USER_DISABLED = "disablecUser";
    public static final String USER_TOO_MANY_ATTEMPTS = "badPasswordUser";


    private Map<String, User> userMap = new HashMap<>();
   public ContrivedUserService() {
        userMap.put("user1", new User("user1", "wileyuser1", "password", false));
        userMap.put("user2", new User("user2", "wileyuser2", "password", false));
        userMap.put(USER_DISABLED, new User(USER_DISABLED, USER_DISABLED + "@wiley", "password", true));


    }
    public void putUser(User user) {
       userMap.put(user.getLoginId(), user);
    }
    public User getUserByLoginId(String loginId) {
        return userMap.get(loginId);
    }
}
