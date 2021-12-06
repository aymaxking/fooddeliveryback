package com.blackhole.fooddelivery.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "place")
@NoArgsConstructor
public class Place {
    @Id
    @GeneratedValue
    @Column(name = "place_id")
    private Long id;
    @Column(name = "place")
    String title;
    @Lob
    byte[] img;
    String description;
    @OneToMany(mappedBy="place")
    private List<Menu> menus = new ArrayList<Menu>();

    public Place(String title, byte[] img, String description) {
        this.title = title;
        this.img = img;
        this.description = description;
    }
}