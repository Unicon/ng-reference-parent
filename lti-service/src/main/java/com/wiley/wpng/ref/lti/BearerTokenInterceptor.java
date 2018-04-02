package com.wiley.wpng.ref.lti;

import com.wiley.wpng.ref.lti.jwt.JwtException;
import com.wiley.wpng.ref.lti.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class BearerTokenInterceptor implements ClientHttpRequestInterceptor {

    @Autowired
    private JwtService jwtService;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        try {
            request.getHeaders().add("Authorization", "Bearer " + jwtService.issueJwtForService());
        } catch (JwtException e) {
            throw new IOException(e.getMessage(), e);
        }
        return execution.execute(request, body);
    }
}
