package com.wiley.wpng.ref.lti;

import com.wiley.wpng.ref.lti.jwt.JwtService;
import com.wiley.wpng.ref.lti.jwt.KeyPairService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jose4j.jwk.JsonWebKeySet;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
public class LTILaunchController implements InitializingBean {
    private static Log log = LogFactory.getLog(LTILaunchController.class);

    @Autowired
    private JwtService jwtService;

    @Autowired
    private KeyPairService keyPairService;

    private String jwksJson = null;



    @GetMapping("/launch")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "tool";
    }



    @RequestMapping(value = "/oidc/jwks", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> jwks() {

//        JsonWebKeySet jwks = keyPairService.getKeyInfo().getJsonWebKeySet();
//
//        return new ResponseEntity(jwks.toJson(), HttpStatus.OK);
        return new ResponseEntity(jwksJson, HttpStatus.OK);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        jwksJson = keyPairService.getKeyInfo().getJsonWebKeySet().toJson();
        log.info("Initialized jwksJSON with: " + jwksJson);

    }
}
