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
    private List<TypeVo> types = new ArrayList<TypeVo>();

    public CategoryVo(String title, List<TypeVo> types) {
        this.title = title;
        this.types = types;
    }

    public CategoryVo(String title) {
        this.title = title;
    }


}
