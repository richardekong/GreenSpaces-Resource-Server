package com.daveace.greenspaces.park;

import java.time.Instant;

public class ParkDTO {

    private String id;
    private String name;
    private String description;
    private String imageURL;
    private List<Facility> facilities;
    private Address address;
    private Instant createAt;

    public ParkDTO(){}

    public ParkDTO(Park park){
        id = park.getId();
        name = park.getName();
        description = park.getDescription();
        imageURL = park.getImageURL();
        facilities = park.getFacilities();
        address = park.getAddress();
        createAt = park.getCreateAt();
    }

}
