package com.apps.quantitymeasurement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {

    @GetMapping("/login-success")
    public String loginSuccess() {
        return "Google Login Successful!";
    }
}