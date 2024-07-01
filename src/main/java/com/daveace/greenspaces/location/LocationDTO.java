package com.daveace.greenspaces.location;

public class LocationDTO {

    private int id;
    private Double lat;
    private Double lng;

    public LocationDTO() {
    }

    public LocationDTO(Location location) {
        id = location.getId();
        lat = location.getLat();
        lng = location.getLng();
    }

    @Override
    public String toString() {
        return "LocationDTO{" +
                "id=" + id +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
