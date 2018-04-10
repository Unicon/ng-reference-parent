package com.wiley.wpng.ref.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository {
    private List<User> users  = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1, "Sergey", "Morozov", "23232", "smore", "secret", "111"));
        users.add(new User(2, "Linda", "Feng", "573434", "lfeng", "secret", "222"));
        users.add(new User(3, "Parker", "Neff", "7343345", "parker", "password", "333"));


    }

    public User findByLoginName(String loginName) {

        for (User user : users) {
            if (user.getLoginName().equals(loginName)) {
                return user;
            }

        }
        return null;

    }
    public User findByLmsUserId(String lmsUserId) {

        for (User user : users) {
            if (user.getLmsUserId().equals(lmsUserId)) {
                return user;
            }

        }
        return null;

    }

}
