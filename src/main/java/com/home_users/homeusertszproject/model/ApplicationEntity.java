package com.home_users.homeusertszproject.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "application_tb")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String typeApp;
    private String nameApp;
    private Date dateApp;
    private String address;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

}
