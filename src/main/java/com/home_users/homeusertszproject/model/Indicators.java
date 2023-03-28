package com.home_users.homeusertszproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "indicators_tb")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Indicators {

    @Id
    @GeneratedValue
    private Integer id;
    private String nameIndicators;
    private String dataInsert;
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

}
