package com.home_users.homeusertszproject.dto;

import com.home_users.homeusertszproject.model.Address;
import com.home_users.homeusertszproject.model.Client;
import com.home_users.homeusertszproject.model.User;
import com.home_users.homeusertszproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService serviceUser;
    @Autowired
    private AddressService addressService;

    /**
     * Метод добавление/регистрации пользователя/клинта
     * @param client
     */
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

    /**
     * Получение клиента по пользователю
     * @param user
     * @return
     */
    public Client getClient(User user){
        Client client = repository.findClientByUser(user);
        return client;
    }

    public void updateClient(Client clientAuth, Client clientUpdate){
        Client clientNew = repository.findClientById(clientAuth.getId());

        if (clientNew.getAddress() == null){
            /*clientNew.setAddress(Address.builder()
                    .city(clientUpdate.getAddress().getCity())
                    .street(clientUpdate.getAddress().getStreet())
                    .numberHouse(clientUpdate.getAddress().getNumberHouse())
                    .corpus(clientUpdate.getAddress().getCorpus())
                    .flat(clientUpdate.getAddress().getFlat())
                    .client(clientNew)
                    .build());*/
            clientNew.setAddress(addressService.createAddress(clientUpdate));
            clientNew.getAddress().setClient(clientNew);
        }

        repository.save(clientNew);
    }

}
