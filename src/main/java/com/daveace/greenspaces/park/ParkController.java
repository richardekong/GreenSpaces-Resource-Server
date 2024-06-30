package com.daveace.greenspaces.park;

import org.springframework.beans.factory.annotation.Autowired;

public class ParkController {

    private ParkService parkService;

    @Autowired
    public void setParkService(ParkService parkService) {
        this.parkService = parkService;
    }
}
