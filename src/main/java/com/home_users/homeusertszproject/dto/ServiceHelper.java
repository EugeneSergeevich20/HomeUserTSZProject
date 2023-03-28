package com.home_users.homeusertszproject.dto;

import com.home_users.homeusertszproject.model.Client;
import com.home_users.homeusertszproject.service.UserDetailsImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Вспомогательный класс/сервис
 */
@Service
public class ServiceHelper {

    @Autowired
    private ClientService serviceClient;

    /**
     * Получение аутентифицированного клиента
     * @param authentication
     * @return
     */
    public Client getClient(Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return serviceClient.getClient(userDetails.getUser());
    }

}
