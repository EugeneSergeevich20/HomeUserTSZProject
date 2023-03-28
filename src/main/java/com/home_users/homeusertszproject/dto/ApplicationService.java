package com.home_users.homeusertszproject.dto;

import com.home_users.homeusertszproject.model.ApplicationEntity;
import com.home_users.homeusertszproject.model.Client;
import com.home_users.homeusertszproject.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {



    public ApplicationEntity create(ApplicationEntity application, Client client){
        var applicationNew = ApplicationEntity.builder()
                .typeApp(application.getTypeApp())
                .nameApp(application.getNameApp())
                .dateApp(application.getDateApp())
                .address(application.getAddress())
                .description(application.getDescription())
                .client(client)
                .build();
        return applicationNew;
    }

}
