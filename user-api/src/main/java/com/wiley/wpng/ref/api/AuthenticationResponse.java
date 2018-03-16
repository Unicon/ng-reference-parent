package com.wiley.wpng.ref.api;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationResponse {
    @Getter @Setter
    private String id;
    @Getter @Setter
    private Map<String, Object> attributes = new HashMap<>();
}
