package com.blackhole.fooddelivery.demo.domaine.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class CategoryVo {
    private Long id;
    private String title;

    public CategoryVo(String title) {
        this.title = title;
    }
}
