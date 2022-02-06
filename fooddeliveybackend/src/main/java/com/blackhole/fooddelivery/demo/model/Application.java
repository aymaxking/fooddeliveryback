package com.blackhole.fooddelivery.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "application")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "application_type")
public class Application {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String date;
    private String email;
    private String number;
    private String etat;
    @Lob
    @Column(name = "picture", length = 100000)
    byte[] img;
}
