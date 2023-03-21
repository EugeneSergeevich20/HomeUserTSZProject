package com.home_users.homeusertszproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "client_tb")
public class Client {

    @Id
    @Column(name = "client_id")
    public int id;

    @Column(name = "phone")
    public String phone;

    @Column(name = "email")
    public String email;

    @Column(name = "surname")
    public String surname;

    @Column(name = "name")
    public String name;

    @Column(name = "patronymic")
    public String patronymic;

    @OneToOne (cascade= CascadeType.ALL)
    @JoinColumn(name = "user_client_id")
    public User user;

    public Client(){}

    public Client(int id, String phone, String email, String surname, String name, String patronymic, User user) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
