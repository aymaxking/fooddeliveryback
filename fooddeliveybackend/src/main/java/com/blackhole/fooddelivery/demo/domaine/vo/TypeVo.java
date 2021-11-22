package com.blackhole.fooddelivery.demo.domaine.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class TypeVo {
    private Long id;
    String title;
    @Lob
    byte[] icon;

    public TypeVo(String title, byte[] icon) {
        this.title = title;
        this.icon = icon;
    }
}
