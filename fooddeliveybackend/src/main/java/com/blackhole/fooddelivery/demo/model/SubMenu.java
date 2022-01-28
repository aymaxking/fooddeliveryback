package com.blackhole.fooddelivery.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "subMenu")
@NoArgsConstructor
public class SubMenu {
    @Id
    @GeneratedValue
    @Column(name = "subMenu_id")
    private Long id;
    @Column(name = "subMenu")
    String title;
    double price;
    @Lob
    @Column(name = "img", length = 10000000)
    byte[] img;

    public SubMenu(String title, double price, byte[] img) {
        this.title = title;
        this.price = price;
        this.img = img;
    }
}
