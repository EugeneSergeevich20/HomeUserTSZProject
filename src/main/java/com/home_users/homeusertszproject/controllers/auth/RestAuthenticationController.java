package com.home_users.homeusertszproject.controllers.auth;

import com.home_users.homeusertszproject.dto.ClientService;
import com.home_users.homeusertszproject.dto.UserService;
import com.home_users.homeusertszproject.model.Client;
import com.home_users.homeusertszproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/auth")
public class RestAuthenticationController {

    @Autowired
    private UserService serviceUser;
    @Autowired
    private ClientService serviceClient;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/register")
    public ModelAndView addNewUser(@ModelAttribute("clientRegister") Client client){
        System.out.println("register");
        serviceClient.addClient(client);
        return new ModelAndView("auth/login");
    }

    /*@GetMapping("/home")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getIndex(){
        return "page/index";
    }*/

}
