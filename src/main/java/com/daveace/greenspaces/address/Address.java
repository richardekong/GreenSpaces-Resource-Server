package com.daveace.greenspaces.address;


import com.daveace.greenspaces.location.Location;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import static com.daveace.greenspaces.util.Constant.*;
import static com.daveace.greenspaces.util.Regexp.LETTER_REGEX;
import static com.daveace.greenspaces.util.Regexp.POSTCODE_REGEX;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Setter
@Getter
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    private String id;

    @NotBlank
    private String description;

    @Pattern(regexp = POSTCODE_REGEX, message = INVALID_POSTCODE)
    @NotBlank
    private String postcode;

    @Pattern(regexp = LETTER_REGEX, message = INVALID_CITY)
    @NotBlank
    private String city;

    @Pattern(regexp = LETTER_REGEX, message = INVALID_COUNTRY)
    private String country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @JsonManagedReference
    private Location location;
    private final Instant createdAt = Instant.now();
    private Instant modifiedAt;

    @PrePersist
    public void onSave() {
        id = UUID.randomUUID().toString();
    }

    @PreUpdate
    public void onUpdate() {
        modifiedAt = Instant.now();
    }

    public AddressDTO toDTO() {
        return new AddressDTO(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(description, address.description) && Objects.equals(postcode, address.postcode) && Objects.equals(city, address.city) && Objects.equals(country, address.country) && Objects.equals(location, address.location) && Objects.equals(createdAt, address.createdAt) && Objects.equals(modifiedAt, address.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, postcode, city, country, location, createdAt, modifiedAt);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", location=" + location +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
