package com.blackhole.fooddelivery.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "order")
@NoArgsConstructor
public class Order{
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;
    private String date;
    private String heure;
    private String etat;

    @ManyToOne()
    private Client client;

    @ManyToOne()
    private Delivery delivery;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="order_id", nullable = false)
    private List<SubMenu> items = new ArrayList<SubMenu>();

}
