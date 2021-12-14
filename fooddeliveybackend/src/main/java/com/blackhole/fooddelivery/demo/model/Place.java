package com.blackhole.fooddelivery.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "place")
@NoArgsConstructor
@Entity
@DiscriminatorValue("P")
public class Place extends User{
    @Column(name = "place")
    String title;
    @Lob
    byte[] img;
    String description;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="place_id", nullable=false)
    private List<Location> locations = new ArrayList<Location>();

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="place_id", nullable=false)
    private List<Menu> menus = new ArrayList<Menu>();

    public Place(String title, byte[] img, String description) {
        this.title = title;
        this.img = img;
        this.description = description;
    }
}
