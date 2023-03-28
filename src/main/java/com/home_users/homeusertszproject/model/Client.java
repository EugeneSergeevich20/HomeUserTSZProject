package com.home_users.homeusertszproject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "client_tb")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue
    private int id;

    private String phone;

    private String email;

    private String surname;

    private String name;

    private String patronymic;

    @OneToOne (cascade= CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public User user;


}
