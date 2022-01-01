package com.blackhole.fooddelivery.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
@Data
@NoArgsConstructor
public class ApplicationDelivery extends Application {
    private String birthday;
    private String city;
    private String vehiculeType;
}
