package com.home_users.homeusertszproject.controllers;

import com.home_users.homeusertszproject.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    @GetMapping("/login")
    public String getPage(){
        return "page/login";
    }

    @PostMapping("/login")
    public String getHome(){
        return "redirect:home";
    }

    @GetMapping("/home")
    public String getIndex(){
        return "page/index";
    }

    @GetMapping("/registration")
    public String getRegistration(Model model){
        Client client = new Client();

        model.addAttribute("newClient", client);

        return "page/registration";
    }

}
