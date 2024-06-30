package com.daveace.greenspaces.park;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkService {

    private ParkRepo repo;

    @Autowired
    public void setRepo(ParkRepo repo) {
        this.repo = repo;
    }
}
