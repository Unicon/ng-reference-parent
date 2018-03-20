package com.wiley.wpng.ref.api.auth;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter @Setter
    private String loginId;
    @Getter @Setter
    private String wileyId;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private Boolean disabled = false;
    @Getter @Setter
    private int loginAttempts = 0;

    public User(String loginId, String wileyId, String password, Boolean disabled) {
        this.loginId = loginId;
        this.wileyId = wileyId;
        this.password = password;
        this.disabled = disabled;

    }

}
