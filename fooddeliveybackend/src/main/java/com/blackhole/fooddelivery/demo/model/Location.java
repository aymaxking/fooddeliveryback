package com.blackhole.fooddelivery.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "location")
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private Long id;
    @Column(name = "location")
    String location;

    public Location(String location) {
        this.location = location;
    }
}
