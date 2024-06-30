package com.daveace.greenspaces.facility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityService {

    private FacilityRepo repo;

    @Autowired
    public void setRepo(FacilityRepo repo) {
        this.repo = repo;
    }
}
