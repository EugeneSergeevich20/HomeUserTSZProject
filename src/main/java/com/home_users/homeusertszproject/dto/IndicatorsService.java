package com.home_users.homeusertszproject.dto;

import com.home_users.homeusertszproject.model.ApplicationEntity;
import com.home_users.homeusertszproject.model.Client;
import com.home_users.homeusertszproject.model.Indicators;
import org.springframework.stereotype.Service;

@Service
public class IndicatorsService {

    public Indicators create(Indicators indicators, Client client){
        var indicatorsNew = Indicators.builder()
                .nameIndicators(indicators.getNameIndicators())
                .dataInsert(indicators.getDataInsert())
                .date(indicators.getDate())
                .client(client)
                .build();
        return indicatorsNew;
    }

}
