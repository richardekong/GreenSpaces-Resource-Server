package com.daveace.greenspaces.park;

import com.daveace.greenspaces.address.Address;
import com.daveace.greenspaces.facility.Facility;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.*;

import static com.daveace.greenspaces.util.Constant.INVALID_IMAGE_URL;
import static com.daveace.greenspaces.util.Constant.INVALID_NAME;
import static com.daveace.greenspaces.util.Regexp.IMAGE_URL_REGEX;
import static com.daveace.greenspaces.util.Regexp.LETTER_REGEX;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
@Getter
@Setter
public class Park {

    @Id
    private String id;

    @Pattern(regexp=LETTER_REGEX, message=INVALID_NAME)
    private String name;

    @NotBlank
    private String description;

    @Pattern(regexp=IMAGE_URL_REGEX, message=INVALID_IMAGE_URL)
    @Column(name="image_url")
    private String imageURL;

    @OneToMany(mappedBy = "park", fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JsonManagedReference
    @Size(min=1)
    private List<Facility> facilities;

    @NotNull
    private Address address;

    private final Instant createAt = Instant.now();

    @Column(name="modified_at")
    private Instant modifiedAt;


    @PrePersist
    public void onSave(){
        id = UUID.randomUUID().toString();
    }

    @PreUpdate
    public void onUpdate(){
        modifiedAt=Instant.now();
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


