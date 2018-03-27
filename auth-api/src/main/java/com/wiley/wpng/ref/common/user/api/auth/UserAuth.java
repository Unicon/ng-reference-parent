package com.wiley.wpng.ref.common.user.api.auth;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class UserAuth {


    @Id
    @Getter
    private Long id;





    @Getter @Setter
    private String loginName;


    @Getter @Setter
    private String password;


    @Getter @Setter
    private Integer loginAttempts = 0;



    public UserAuth(Long id, String loginName, String password) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.loginAttempts = 0;


    }

    public UserAuth() {

    }






}
