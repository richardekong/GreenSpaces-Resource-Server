package com.daveace.greenspaces.facility;

import com.daveace.greenspaces.park.Park;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Setter
@Getter
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;
    private final Instant createdAt = Instant.now();
    @Column(name="modified_at")
    private Instant modifiedAt = Instant.now();

    @ManyToOne
    @JoinColumn(name="park_id")
    @JsonBackReference
    private Park park;

    @PrePersist
    public void init(){
        id = UUID.randomUUID().toString();
        modifiedAt = Instant.now();
    }

    @PreUpdate
    public void doBeforeUpdating(){
        modifiedAt = Instant.now();
    }

    public FacilityDTO toDTO(){
        return new FacilityDTO(this);
    }

    @Override
    public String toString() {
        return "Facility{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return Objects.equals(id, facility.id) && Objects.equals(name, facility.name) && Objects.equals(description, facility.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
