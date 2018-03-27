package com.wiley.wpng.ref.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class User {


    @Getter @Setter
    private Integer id;

    @JsonProperty("first_name")
    @Getter @Setter
    private String firstName;

    @JsonProperty("last_name")
    @Getter @Setter
    private String lastName;



    @JsonProperty("user_type")
    @Getter @Setter
    private String userType = "W";

    @JsonProperty("user_role")
    @Getter @Setter
    private String userRole = "student";

    @JsonProperty("student_id")
    @Getter @Setter
    private String studentId;

    @JsonProperty("accepted_tos")
    @Getter @Setter
    private Boolean acceptedTOS = false;


    @JsonProperty("login_name")
    @Getter @Setter
    private String loginName;

    @JsonIgnore
    @Getter @Setter
    private String password;

    @JsonIgnore
    @Getter @Setter
    private Integer loginAttempts = 0;

    public boolean isDisabled() {
        return loginAttempts > 3;

    }



    public User(Integer id, String firstName, String lastName, String studentId,  String loginName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.loginName = loginName;
        this.password = password;
    }


    @Override
    public String toString() {
        return String.format(
                "User[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }


}

