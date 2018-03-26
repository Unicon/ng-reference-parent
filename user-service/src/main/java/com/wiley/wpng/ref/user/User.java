package com.wiley.wpng.ref.user;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Getter
    private Long id;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private String loginName;
    @Getter @Setter
    private String userType;
    @Getter @Setter
    private String userRole;
    @Getter @Setter
    private String studentId;
    @Getter @Setter
    private String password;

    public User() {}



    @Override
    public String toString() {
        return String.format(
                "User[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }


}
