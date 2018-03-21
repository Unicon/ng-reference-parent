package com.wiley.wpng.ref.api.auth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
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



    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();


    }
    @Test
    public void testValidAuth() throws Exception {

        this.mockMvc.perform(post("/auth")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("login_name", "user1")
                .param("password", "password")).andExpect(status().isOk());

    }

    @Test
    public void testInvalidAuth() throws Exception {

        this.mockMvc.perform(post("/auth")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("login_name", "user1")
                .param("password", "password1")).andExpect(status().isNotFound());

    }

    @Test
    public void testDisabledUser() throws Exception {

        this.mockMvc.perform(post("/auth")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("login_name", ContrivedUserService.USER_DISABLED)
                .param("password", "password")).andExpect(status().isLocked());

    }


    @Test
    public void testLockout() throws Exception {

        this.mockMvc.perform(post("/auth")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("login_name", "user2")
                .param("password", "password1")).andExpect(status().isNotFound());
        this.mockMvc.perform(post("/auth")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("login_name", "user1")
                .param("password", "password1")).andExpect(status().isNotFound());
        this.mockMvc.perform(post("/auth")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("login_name", "user1")
                .param("password", "password1")).andExpect(status().isNotFound());
        this.mockMvc.perform(post("/auth")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("login_name", "user1")
                .param("password", "password1")).andExpect(status().isLocked());


    }


}
