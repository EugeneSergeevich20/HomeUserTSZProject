package com.home_users.homeusertszproject.controllers.auth;

import com.home_users.homeusertszproject.dto.ClientService;
import com.home_users.homeusertszproject.dto.ServiceHelper;
import com.home_users.homeusertszproject.dto.UserService;
import com.home_users.homeusertszproject.model.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/auth")
public class RestAuthenticationController {
    @Autowired
    private ClientService serviceClient;
    @Autowired
    private ServiceHelper serviceHelper;


    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/register")
    public ModelAndView addNewClient(@ModelAttribute("clientRegister") @Valid Client client, BindingResult bindingResult){
        System.out.println("register");

        if(bindingResult.hasErrors())
            return new ModelAndView("auth/register");;

        serviceClient.addClient(client);
        return new ModelAndView("auth/login");
    }

    @PostMapping("/profile/update")
    public ModelAndView getProfileUpdate(Authentication authentication,
                                         @ModelAttribute("modelHelper") ModelHelper modelHelper){
        Client clientAuth = serviceHelper.getClient(authentication);
        //modelHelper.setClient(clientAuth);
        serviceClient.updateClient(clientAuth, modelHelper.getClient());
        return new ModelAndView("redirect:/auth/news");
    }

    @PostMapping("/application/new")
    public ModelAndView applicationNew(Authentication authentication,
                                         @ModelAttribute("modelHelper") ModelHelper modelHelper){
        Client clientAuth = serviceHelper.getClient(authentication);
        modelHelper.setClient(clientAuth);
        serviceHelper.applicationNew(modelHelper.getApplicationEntity(), modelHelper.getClient());
        return new ModelAndView("redirect:/auth/news");
    }

    @PostMapping("/indicators/new")
    public ModelAndView indicatorsNew(Authentication authentication,
                                       @ModelAttribute("indicatorsNew") Indicators indicators){
        Client clientAuth = serviceHelper.getClient(authentication);
        serviceHelper.indicatorsNew(indicators, clientAuth);
        return new ModelAndView("redirect:/auth/news");
    }

    @PostMapping("/login")
    public String loginClient(){
        System.out.println("==========================================================");
        System.out.println("\t\t\t\t\tClient is login");
        System.out.println("==========================================================");
        return "Client is login";
    }

}
