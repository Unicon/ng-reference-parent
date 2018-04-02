package com.wiley.wpng.ref.user.api.auth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class AuthControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;



    //@Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();


    }
    @Test
    public void testValidAuth() throws Exception {

//        this.mockMvc.perform(post("/auth")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("login_name", "user1")
//                .param("password", "password")).andExpect(status().isOk());

    }

    //@Test
    public void testInvalidAuth() throws Exception {

        this.mockMvc.perform(post("/auth")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("login_name", "user1")
                .param("password", "password1")).andExpect(status().isNotFound());

    }

//    @Test
//    public void testDisabledUser() throws Exception {
//
//        this.mockMvc.perform(post("/auth")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("login_name", ContrivedUserService.USER_DISABLED)
//                .param("password", "password")).andExpect(status().isLocked());
//
//    }





}
