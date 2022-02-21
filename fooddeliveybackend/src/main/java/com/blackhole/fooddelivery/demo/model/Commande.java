package com.blackhole.fooddelivery.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "commande")
@NoArgsConstructor
public class Commande {
    @Id
    @GeneratedValue
    @Column(name = "commande_id")
    private Long id;
    private String date;
    private String heure;
    private String etat;
    private Long idclient;
    private Long iddelivery;
    @ManyToOne()
    private Client client;

    @ManyToOne()
    private Delivery delivery;

    @ManyToMany()
    private List<SubMenu> items = new ArrayList<SubMenu>();


}
