package com.home_users.homeusertszproject.controllers.auth;

import com.home_users.homeusertszproject.dto.UserService;
import com.home_users.homeusertszproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/auth")
public class RestAuthenticationController {

    @Autowired
    private UserService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/register")
    public ModelAndView addNewUser(@ModelAttribute("user") User userInfo){
        System.out.println("register");
        service.addUser(userInfo);
        return new ModelAndView("auth/login");
    }

    /*@GetMapping("/home")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getIndex(){
        return "page/index";
    }*/

}
