package com.home_users.homeusertszproject.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user_tb")
public class User {

    @Id
    @Column(name = "user_id")
    public int id;

    @Column(name = "login")
    public String login;

    @Column(name = "password")
    public String password;

    @Column(name = "active")
    public boolean active;

    @OneToOne (mappedBy = "user", cascade = CascadeType.ALL)
    public Client client;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_client_id"))
    public Set<Role> roles;

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
