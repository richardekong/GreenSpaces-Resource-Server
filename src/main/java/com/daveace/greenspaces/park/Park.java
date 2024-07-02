package com.daveace.greenspaces.park;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
@Getter
@Setter
@Entity
@Table(name="parks")
public class Park {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;
    @Column(name="image_url")
    private String imageURL;
    @OneToMany(mappedBy = "park", fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private List<Facility> facilities;
    private Address address;
    private Instant createAt;


    @PrePersist
    public void init(){
        id = UUID.randomUUID().toString();
        createAt = Instant.now();
    }

}


