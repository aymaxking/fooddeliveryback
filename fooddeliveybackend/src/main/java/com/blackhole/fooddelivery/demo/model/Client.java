package com.blackhole.fooddelivery.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
@Data
@NoArgsConstructor
public class Client extends User{
    private String name;
    private String birthday;
    private String CIN;
    private String home_adresse;
}
