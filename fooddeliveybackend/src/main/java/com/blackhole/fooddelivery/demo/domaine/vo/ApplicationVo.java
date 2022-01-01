package com.blackhole.fooddelivery.demo.domaine.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class ApplicationVo {
    private Long id;
    private String name;
    private String date;
    private  String email;
    private String number;

    public ApplicationVo(String name, String date, String email, String number) {
        this.name = name;
        this.date = date;
        this.email = email;
        this.number = number;
    }
}
