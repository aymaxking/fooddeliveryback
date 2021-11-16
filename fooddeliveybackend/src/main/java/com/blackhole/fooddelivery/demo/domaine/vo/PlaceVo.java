package com.blackhole.fooddelivery.demo.domaine.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class PlaceVo {
    private Long id;
    String title;
    @Lob
    byte[] img;
    String description;

    public PlaceVo(String title, byte[] img, String description) {
        this.title = title;
        this.img = img;
        this.description = description;
    }
}
