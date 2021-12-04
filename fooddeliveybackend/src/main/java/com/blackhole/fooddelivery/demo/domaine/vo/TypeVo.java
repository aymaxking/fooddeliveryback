package com.blackhole.fooddelivery.demo.domaine.vo;

import com.blackhole.fooddelivery.demo.model.Category;
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
    private CategoryVo category;

    public TypeVo(String title, byte[] icon,CategoryVo category) {
        this.title = title;
        this.icon = icon;
        this.category=category;
    }
}
