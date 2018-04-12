package com.wiley.wpng.ref.lti;

import com.wiley.wpng.ref.common.User;
import com.wiley.wpng.ref.common.com.wiley.wpng.ref.common.entity.LtiConsumer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RestClient {

    private Log log = LogFactory.getLog(RestClient.class);

    @Autowired
    private RestTemplate restTemplate;



    @Value("${user.api.endpoint}")
    private String userApiEndpoint;

    @Value("${consumer.api.endpoint}")
    private String consumerApiEndpoint;



    public User getUser(String lmsUserId, String canvasUserId, Long institutionId) {


        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(userApiEndpoint)
                .queryParam("role", "student")
                .queryParam("instititution_id", institutionId)
                .queryParam("lti_user_id", "111")
                .queryParam("canvas_user_id", canvasUserId);


        log.info("Sending the following request: " + builder.build().encode().toUriString());

        HttpEntity<User>  response = restTemplate.getForEntity(builder.build().encode().toUriString(), User.class);
        User user = null;
        try {
            user = response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public LtiConsumer getLtiConsumer(String consumerKey) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(consumerApiEndpoint)
                .queryParam("consumerKey", "student");



        log.info("Sending the following request: " + builder.build().encode().toUriString());

        HttpEntity<LtiConsumer>  response = restTemplate.getForEntity(builder.build().encode().toUriString(), LtiConsumer.class);
        LtiConsumer ltiConsumer = null;
        try {
            ltiConsumer = response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ltiConsumer;
    }
}
