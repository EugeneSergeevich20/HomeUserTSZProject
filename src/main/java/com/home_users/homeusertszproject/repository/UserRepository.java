package com.home_users.homeusertszproject.repository;

import com.home_users.homeusertszproject.model.Client;
import com.home_users.homeusertszproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByLogin(String username);

    User findUserByClient(Client client);

}
