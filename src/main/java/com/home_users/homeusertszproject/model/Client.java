package com.home_users.homeusertszproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Set;

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

    @NotEmpty(message = "Введите номер телефона")
    private String phone;

    @NotEmpty(message = " Введите email")
    @Email
    private String email;

    @NotEmpty(message = "Введите фамилию")
    private String surname;

    @NotEmpty(message = "Введите имя")
    private String globalName;

    @NotEmpty(message = "Введите отчество")
    private String patronymic;

    @OneToOne (cascade= CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public User user;

    @OneToOne (mappedBy = "client", cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<ApplicationEntity> applicationList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Indicators> indicatorsList;


}
