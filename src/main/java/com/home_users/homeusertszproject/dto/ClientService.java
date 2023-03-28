package com.home_users.homeusertszproject.dto;

import com.home_users.homeusertszproject.model.Client;
import com.home_users.homeusertszproject.model.User;
import com.home_users.homeusertszproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService serviceUser;

    public void addClient(Client client) {
        //var user = new User();
        var clientNew = Client.builder()
                .phone(client.getPhone())
                .email(client.getEmail())
                .surname(client.getSurname())
                .name(client.getName())
                .patronymic(client.getPatronymic())
                .user(User.builder()
                        .login(client.user.getLogin())
                        .password(passwordEncoder.encode(client.user.getPassword()))
                        .roles("ROLE_USER")
                        .build())
                .build();
        repository.save(clientNew);
    }

}
