package com.msglearning.javabackend.controllers;

import com.msglearning.javabackend.entity.User;
import com.msglearning.javabackend.services.PasswordService;
import com.msglearning.javabackend.services.TokenService;
import com.msglearning.javabackend.services.UserService;
import com.msglearning.javabackend.to.UserTO;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

@RestController
@RequestMapping({ ControllerConstants.API_PATH_AUTH })
public class AuthController {

    private static final String REGISTER_PATH = "/register";
    private static final String LOGIN_PATH = "/login";
    public static final String AUTHORIZATION = "authorization";

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @PostMapping(REGISTER_PATH)
    public boolean register(@RequestBody UserTO userTO) {

        try {
            userService.save(userTO);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @PostMapping(LOGIN_PATH)
    public String login(@RequestHeader Map<String, String> headers) {

        String decodedAuthHeader = new String(Base64.decodeBase64(headers.get(AUTHORIZATION).substring(6)));
        String email = decodedAuthHeader.substring(0, decodedAuthHeader.indexOf(":"));
        String pw = decodedAuthHeader.substring(decodedAuthHeader.indexOf(":") + 1);

        if ( !StringUtils.hasLength(email) || !StringUtils.hasLength(pw)) {

            return "Forbidden cause no email/password";
        }

        Optional<User> userOpt = this.userService.findByEmail(email);
        if (userOpt.isPresent() && PasswordService.checkPassword(pw, userOpt.get().getPassword())) {

            // Create token
            return this.tokenService.createTokenHeader(userOpt.get().getEmail(), "USER");
        }

        return "Forbidden";

    }

}
