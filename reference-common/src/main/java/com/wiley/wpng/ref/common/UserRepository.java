package com.wiley.wpng.ref.common;

import java.util.ArrayList;
import java.util.List;


public class UserRepository {
    private List<User> users  = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1, "Sergey", "Morozov", "23232", "smore", "secret"));
        users.add(new User(2, "Linda", "Feng", "573434", "lfeng", "secret"));
        users.add(new User(3, "Parker", "Neff", "7343345", "parker", "password"));


    }

    public User findByLoginName(String loginName) {

        for (User user : users) {
            if (user.getLoginName().equals(loginName)) {
                return user;
            }

        }
        return null;

    }

}
