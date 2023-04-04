package com.home_users.homeusertszproject.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModelHelper {

    private Client client;
    private Address address;
    private Indicators indicators;
    private ApplicationEntity applicationEntity;

}
