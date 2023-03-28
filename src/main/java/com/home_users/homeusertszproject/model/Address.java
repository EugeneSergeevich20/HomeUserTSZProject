package com.home_users.homeusertszproject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address_tb")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private Integer id;
    private String city;
    private String street;
    private String numberHouse;
    private String corpus;
    private String flat;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;


}
