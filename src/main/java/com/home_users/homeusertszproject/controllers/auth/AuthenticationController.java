package com.home_users.homeusertszproject.controllers.auth;

import com.home_users.homeusertszproject.dto.UserService;
import com.home_users.homeusertszproject.model.Client;
import com.home_users.homeusertszproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String getPage() {
        return "auth/login";
    }

    @GetMapping("/home")
    public String getIndex(){
        return "auth/home";
    }

    @GetMapping("/register")
    public String registerUser(Model model){
        /*User user = new User();
        model.addAttribute("user", user);*/
        Client client = new Client();
        model.addAttribute("clientRegister", client);
        return "auth/register";
    }


}
