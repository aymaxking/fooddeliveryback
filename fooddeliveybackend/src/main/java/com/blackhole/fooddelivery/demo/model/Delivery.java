package com.blackhole.fooddelivery.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
@Data
@NoArgsConstructor
public class Delivery extends User{
    private String name;
    private String birthday;
    private String CIN;
    private String adresse;
    private String start_date;

}

