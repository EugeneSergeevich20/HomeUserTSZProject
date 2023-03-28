package com.home_users.homeusertszproject.controllers.auth;

import com.home_users.homeusertszproject.dto.ClientService;
import com.home_users.homeusertszproject.dto.ServiceHelper;
import com.home_users.homeusertszproject.dto.UserService;
import com.home_users.homeusertszproject.model.Address;
import com.home_users.homeusertszproject.model.Client;
import com.home_users.homeusertszproject.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserService serviceUser;
    @Autowired
    private ClientService serviceClient;
    @Autowired
    private ServiceHelper serviceHelper;

    @GetMapping("/login")
    public String getPage() {
        return "auth/login";
    }

    @GetMapping("/home")
    public String getIndex(Authentication authentication, Model model){
        Client client = serviceHelper.getClient(authentication);
        model.addAttribute("client", client);
        return "home";
    }


    @GetMapping("/profile")
    public String getProfile(Authentication authentication, Model model){
        Client client = serviceHelper.getClient(authentication);
        model.addAttribute("clientDetails", client);

        return "profile/profile";
    }

    @GetMapping("/accruals")
    public String getAccruals(Authentication authentication, Model model){
        Client client = serviceHelper.getClient(authentication);
        model.addAttribute("client", client);

        return "accruals";
    }

    @GetMapping("/application")
    public String getApplication(Authentication authentication, Model model){
        Client client = serviceHelper.getClient(authentication);
        model.addAttribute("client", client);

        return "application";
    }

    @GetMapping("/service")
    public String getService(Authentication authentication, Model model){
        Client client = serviceHelper.getClient(authentication);
        model.addAttribute("client", client);

        return "service";
    }

    @GetMapping("/news")
    public String getNews(Authentication authentication, Model model){
        Client client = serviceHelper.getClient(authentication);
        model.addAttribute("client", client);

        return "news/news";
    }

    /**
     * Маппинг регистрации клиента
     * @param model
     * @return
     */
    @GetMapping("/register")
    public String registerClient(Model model){
        Client client = new Client();
        model.addAttribute("clientRegister", client);
        return "auth/register";
    }


}
