package com.home_users.homeusertszproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "user_tb")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    public Integer id;

    public String login;

    public String password;

    @OneToOne (mappedBy = "user", cascade = CascadeType.ALL)
    public Client client;

    private String roles;

}
