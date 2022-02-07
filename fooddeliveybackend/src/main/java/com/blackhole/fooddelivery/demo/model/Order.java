package com.blackhole.fooddelivery.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "order")
@NoArgsConstructor
@Entity
public class Order{
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;
    private String date;
    private String heure;
    private String etat;
    @ManyToOne()
    @JoinColumn(name="client_id", referencedColumnName = "client_id", insertable = false, updatable = false)
    private Client client;
    @ManyToOne()
    @JoinColumn(name="delivery_id", referencedColumnName = "delivery_id", insertable = false, updatable = false)
    private Delivery delivery;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="order_id")
    private List<SubMenu> items = new ArrayList<SubMenu>();

}
