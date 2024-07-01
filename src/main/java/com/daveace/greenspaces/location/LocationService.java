package com.daveace.greenspaces.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private LocationRepo repo;

    @Autowired
    public void setRepo(LocationRepo repo) {
        this.repo = repo;
    }
}
