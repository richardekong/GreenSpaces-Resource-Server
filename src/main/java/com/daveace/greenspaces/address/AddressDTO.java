package com.daveace.greenspaces.address;

public class AddressDTO {

    private String id;
    private String description;
    private String postcode;
    private String city;
    private String country;
    private Location location;

    public AddressDTO() {
    }

    public AddressDTO(Address address) {
        id = address.getId();
        description = address.getDescription();
        postcode = address.getPostcode();
        city = address.getCity();
        country = address.getCountry();
        location = address.getLocation();
    }
}
