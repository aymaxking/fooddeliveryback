package com.blackhole.fooddelivery.demo.domaine.vo;

import com.blackhole.fooddelivery.demo.model.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class SubMenuVo {
    private Long id;
    String title;
    double price;
    @Lob
    byte[] img;


    public void setImg(byte[] img) {
        this.img = img;
    }

    public SubMenuVo(String title, double price, byte[] img) {
        this.title = title;
        this.price = price;
        this.img = img;
    }
}
