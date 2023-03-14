package com.home_users.homeusertszproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/autho")
    public String getPage(){
        return "page/authorizationPhoneNumber";
    }

}
