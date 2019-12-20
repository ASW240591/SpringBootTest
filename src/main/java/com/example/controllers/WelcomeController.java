package com.example.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Welcome;

@RestController
public class WelcomeController {
private static final String welcomemsg = "Welcome Mr. %s!";
    
    @RequestMapping(value="welcome/user", method=RequestMethod.GET)
    public Welcome welcomeUser(@RequestParam(name="name", required=false, defaultValue="Java Fan") String name) {
        return new Welcome(String.format(welcomemsg, name));
    }
}