package com.daveace.greenspaces.park;

import com.daveace.greenspaces.address.Address;
import com.daveace.greenspaces.facility.Facility;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
@Getter
@Setter
public class Park {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;

    @Column(name="image_url")
    private String imageURL;

    @OneToMany(mappedBy = "park", fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JsonManagedReference
    private List<Facility> facilities;
    private Address address;
    private final Instant createAt = Instant.now();

    @Column(name="modified_at")
    private Instant modifiedAt;


    @PrePersist
    public void init(){
        id = UUID.randomUUID().toString();
        modifiedAt = Instant.now();
    }

    public void addFacilities(Collection<Facility>facilities){
        if (this.facilities==null){
            this.facilities=new ArrayList<>();
        }
        facilities.forEach(facility -> {
            this.facilities.add(facility);
            facility.setPark(this);
        });
    }

    public ParkDTO toDTO(){
        return new ParkDTO(this);
    }

    @Override
    public String toString() {
        return "Park{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", facilities=" + facilities +
                ", address=" + address +
                ", createAt=" + createAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Park park = (Park) o;
        return Objects.equals(id, park.id) && Objects.equals(name, park.name) && Objects.equals(description, park.description) && Objects.equals(imageURL, park.imageURL) && Objects.equals(facilities, park.facilities) && Objects.equals(address, park.address) && Objects.equals(createAt, park.createAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, imageURL, facilities, address, createAt);
    }
}


