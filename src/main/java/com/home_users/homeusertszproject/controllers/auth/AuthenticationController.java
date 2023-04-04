package com.home_users.homeusertszproject.controllers.auth;

import com.home_users.homeusertszproject.dto.ClientService;
import com.home_users.homeusertszproject.dto.ServiceHelper;
import com.home_users.homeusertszproject.dto.UserService;
import com.home_users.homeusertszproject.model.ApplicationEntity;
import com.home_users.homeusertszproject.model.Client;
import com.home_users.homeusertszproject.model.Indicators;
import com.home_users.homeusertszproject.model.ModelHelper;
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
    private ServiceHelper serviceHelper;

    private ModelHelper modelHelper;

    @GetMapping("/login")
    public String getPage() {
        return "auth/login";
    }

    @GetMapping("/home")
    public String getIndex(Authentication authentication, Model model){
        Client client = serviceHelper.getClient(authentication);
        Indicators indicators = new Indicators();
        model.addAttribute("client", client);
        model.addAttribute("indicatorsNew", indicators);
        return "home";
    }


    @GetMapping("/profile")
    public String getProfile(Model model){
        model.addAttribute("modelHelper", modelHelper);

        return "profile/profile";
    }

    @GetMapping("/accruals")
    public String getAccruals(Model model){
        model.addAttribute("modelHelper", modelHelper);

        return "accruals";
    }

    @GetMapping("/application")
    public String getApplication(Model model){
        modelHelper.setApplicationEntity(new ApplicationEntity());
        model.addAttribute("modelHelper", modelHelper);

        return "application";
    }

    @GetMapping("/service")
    public String getService(Model model){
        model.addAttribute("modelHelper", modelHelper);
        return "service";
    }

    @GetMapping("/news")
    public String getNews(Authentication authentication, Model model){
        Client client = serviceHelper.getClient(authentication);
        modelHelper = new ModelHelper();
        modelHelper.setClient(client);
        model.addAttribute("modelHelper", modelHelper);

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
