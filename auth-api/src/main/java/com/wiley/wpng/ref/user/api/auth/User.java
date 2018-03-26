package com.wiley.wpng.ref.user.api.auth;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {


    @Id
    @Getter
    private Long id;




    @JsonProperty("login_name")
    @Getter @Setter
    private String loginName;

    @JsonIgnore
    @Getter @Setter
    private String password;



    public User() {}






}
