package com.uol.ms.infra;

import com.uol.ms.model.GroupType;
import com.uol.ms.service.CodinameService;
import org.springframework.stereotype.Component;

@Component
public class CodinamesHandler {
    private final CodinameService service;

    public CodinamesHandler(CodinameService service) {
        this.service = service;
    }


    public String findCodiname(GroupType type){
        if(type == GroupType.AVENGERS){
            String firstMatch = this.service.getAvengersCodinameList().stream().findFirst().orElseThrow();
            this.service.getAvengersCodinameList().remove(firstMatch);

            return firstMatch;
        }


        String firstMatch = this.service.getJusticeLeagueCodinameList().stream().findFirst().orElseThrow();
        this.service.getJusticeLeagueCodinameList().remove(firstMatch);

        return firstMatch;


    }
}
