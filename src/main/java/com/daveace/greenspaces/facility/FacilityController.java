package com.daveace.greenspaces.facility;

import org.springframework.beans.factory.annotation.Autowired;

public class FacilityController {

    private FacilityService facilityService;

    @Autowired
    public void setFacilityService(FacilityService facilityService) {
        this.facilityService = facilityService;
    }
}
