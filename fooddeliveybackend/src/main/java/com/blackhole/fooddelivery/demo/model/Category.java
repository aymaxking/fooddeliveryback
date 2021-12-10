package com.blackhole.fooddelivery.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "category")
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;
    @Column(name = "category")
    private String title;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="category_id", nullable=false)
    private List<Type> types = new ArrayList<Type>();

    public Category(String title) {
        this.title = title;
    }
}
