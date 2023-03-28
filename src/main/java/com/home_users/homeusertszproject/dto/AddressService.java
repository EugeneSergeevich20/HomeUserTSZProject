package com.home_users.homeusertszproject.dto;

import com.home_users.homeusertszproject.model.Address;
import com.home_users.homeusertszproject.model.Client;
import com.home_users.homeusertszproject.repository.AddressRepository;
import com.home_users.homeusertszproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Address createAddress(Client client){
        Address address = new Address();
        address = Address.builder()
                .city(client.getAddress().getCity())
                .street(client.getAddress().getStreet())
                .numberHouse(client.getAddress().getNumberHouse())
                .corpus(client.getAddress().getCorpus())
                .flat(client.getAddress().getFlat())
                .build();
        return address;
    }

}
