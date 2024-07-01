package com.daveace.greenspaces.park;

import com.daveace.greenspaces.address.Address;
import com.daveace.greenspaces.facility.Facility;

import java.time.Instant;
import java.util.List;

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
