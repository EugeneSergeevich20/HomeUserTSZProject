package com.home_users.homeusertszproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "login")
    public String login;

    @Column(name = "password")
    public String password;

    @OneToOne (cascade= CascadeType.ALL)
    @JoinColumn(name = "client_id")
    public Client client;

    public User(){}

    public User(int id, String login, String password, Client client) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
