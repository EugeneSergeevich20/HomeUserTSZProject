package com.home_users.homeusertszproject.dto;

import com.home_users.homeusertszproject.model.User;
import com.home_users.homeusertszproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User addUser(User userInfo) {
        var user = User.builder()
                .login(userInfo.getLogin())
                .password(passwordEncoder.encode(userInfo.getPassword()))
                .roles("ROLE_USER")
                .build();
        repository.save(user);
        return user;
    }

}
