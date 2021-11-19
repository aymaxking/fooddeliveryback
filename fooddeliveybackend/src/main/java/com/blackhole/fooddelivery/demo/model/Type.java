package com.blackhole.fooddelivery.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "type")
@NoArgsConstructor
public class Type {
    @Id
    @GeneratedValue
    @Column(name = "type_id")
    private Long id;
    @Column(name = "type")
    String title;
    @Lob
    byte[] icon;


    public Type(String title, byte[] icon,Category category) {
        this.title = title;
        this.icon = icon;
    }
}
