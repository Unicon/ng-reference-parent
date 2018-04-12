package com.wiley.wpng.ref.ltic.api;


import com.wiley.wpng.ref.common.com.wiley.wpng.ref.common.entity.Institution;
import com.wiley.wpng.ref.common.com.wiley.wpng.ref.common.entity.LtiConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>ystartsev</a>
 * @version 09.10.2017
 */
@RestController
@RequestMapping("/consumers")
public class LtiConsumerController {
    private static final Logger LOG = LoggerFactory.getLogger(LtiConsumerController.class);







    @RequestMapping(path = "/search", method = GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity<LtiConsumer> search(
            @RequestParam(value = "consumerKey") String consumerKey) {

        LtiConsumer consumer = new LtiConsumer();
        consumer.setId(new Long(111));
        consumer.setConsumerKey(consumerKey);

        Institution institution = new Institution();
        institution.setId(new Long(123));
        institution.setInstitutionName("Unicollege");
        consumer.setInstitution(institution);

        if (Objects.isNull(consumer)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(consumer);


    }


}
