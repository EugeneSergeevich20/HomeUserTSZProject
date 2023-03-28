package com.home_users.homeusertszproject.controllers.auth;

import com.home_users.homeusertszproject.dto.ClientService;
import com.home_users.homeusertszproject.dto.ServiceHelper;
import com.home_users.homeusertszproject.dto.UserService;
import com.home_users.homeusertszproject.model.ApplicationEntity;
import com.home_users.homeusertszproject.model.Client;
import com.home_users.homeusertszproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/auth")
public class RestAuthenticationController {

    @Autowired
    private UserService serviceUser;
    @Autowired
    private ClientService serviceClient;
    @Autowired
    private ServiceHelper serviceHelper;


    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/register")
    public ModelAndView addNewClient(@ModelAttribute("clientRegister") Client client){
        System.out.println("register");
        serviceClient.addClient(client);
        return new ModelAndView("auth/login");
    }

    @PostMapping("/profile/update")
    public ModelAndView getProfileUpdate(Authentication authentication,
                                         @ModelAttribute("clientDetails") Client client){
        Client clientAuth = serviceHelper.getClient(authentication);
        serviceClient.updateClient(clientAuth, client);
        return new ModelAndView("profile/profile");
    }

    @PostMapping("/application/new")
    public ModelAndView applicationNew(Authentication authentication,
                                         @ModelAttribute("applicationNew") ApplicationEntity application){
        Client clientAuth = serviceHelper.getClient(authentication);
        serviceHelper.applicationNew(application, clientAuth);
        return new ModelAndView("application");
    }

    @PostMapping("/login")
    public String loginClient(){
        System.out.println("==========================================================");
        System.out.println("\t\t\t\t\tClient is login");
        System.out.println("==========================================================");
        return "Client is login";
    }

}
