package com.wiley.wpng.ref.common.userapi;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Getter
    private Long id;

    @JsonProperty("first_name")
    @Getter @Setter
    private String firstName;

    @JsonProperty("last_name")
    @Getter @Setter
    private String lastName;



    @JsonProperty("user_type")
    @Getter @Setter
    private String userType;

    @JsonProperty("user_role")
    @Getter @Setter
    private String userRole;

    @JsonProperty("student_id")
    @Getter @Setter
    private String studentId;

    @JsonProperty("accepted_tos")
    @Getter @Setter
    private Boolean acceptedTOS;


    @JsonProperty("login_name")
    @Getter @Setter
    private String loginName;

    @JsonIgnore
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
