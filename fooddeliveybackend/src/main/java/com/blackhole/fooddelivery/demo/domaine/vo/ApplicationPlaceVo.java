package com.blackhole.fooddelivery.demo.domaine.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApplicationPlaceVo extends ApplicationVo {
    private String description;

    public ApplicationPlaceVo(String name, String date, String email, String number, String description,String etat) {
        super(name, date, email, number,etat);
        this.description = description;
    }
}
