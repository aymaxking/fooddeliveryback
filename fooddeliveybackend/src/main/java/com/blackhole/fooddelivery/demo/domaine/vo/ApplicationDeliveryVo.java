package com.blackhole.fooddelivery.demo.domaine.vo;

import com.blackhole.fooddelivery.demo.model.Application;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
public class ApplicationDeliveryVo extends ApplicationVo {
    private String birthday;
    private String city;
    private String vehiculeType;
    private String cin;
    private String adresse;

    public ApplicationDeliveryVo(String name, String date, String email, String number, String birthday, String city, String vehiculeType,String etat,String CIN,String adresse) {
        super(name, date, email, number,etat);
        this.birthday = birthday;
        this.city = city;
        this.vehiculeType = vehiculeType;
        this.cin=CIN;
        this.adresse=adresse;
    }
}
