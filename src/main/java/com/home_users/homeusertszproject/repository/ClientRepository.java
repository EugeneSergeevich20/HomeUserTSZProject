package com.home_users.homeusertszproject.repository;

import com.home_users.homeusertszproject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findBySurname(String surname);

}
