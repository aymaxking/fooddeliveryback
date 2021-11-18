package com.blackhole.fooddelivery.demo.domaine.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CategoryVo {
    private Long id;
    private String title;


    public CategoryVo(String title) {
        this.title = title;
    }
}
