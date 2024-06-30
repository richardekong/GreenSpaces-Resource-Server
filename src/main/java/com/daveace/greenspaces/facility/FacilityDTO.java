package com.daveace.greenspaces.facility;

import com.daveace.greenspaces.park.Park;

public class FacilityDTO {

    private String id;
    private String name;
    private String description;
    private Park park;

    public FacilityDTO() {
    }

    public FacilityDTO(Facility facility) {
        id = facility.getId();
        name = facility.getName();
        description = facility.getDescription();
        park = facility.getPark();
    }
}
