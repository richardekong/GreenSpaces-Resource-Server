package com.daveace.greenspaces.location;


import com.daveace.greenspaces.address.Address;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Setter
@Getter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private Double Lat;

    @NotNull
    private Double Lng;

    @OneToOne(mappedBy = "location")
    @JsonBackReference
    private Address address;

    public LocationDTO toDTO(){
        return new LocationDTO(this);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", Lat=" + Lat +
                ", Lng=" + Lng +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id == location.id && Objects.equals(Lat, location.Lat) && Objects.equals(Lng, location.Lng) && Objects.equals(address, location.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Lat, Lng, address);
    }
}
