package com.blackhole.fooddelivery.demo.domaine.vo;

import com.blackhole.fooddelivery.demo.domaine.converter.TypeConverter;
import com.blackhole.fooddelivery.demo.model.Type;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryVo {
    private Long id;
    private String title;
    private List<TypeVo> types = new ArrayList<TypeVo>();

    public CategoryVo(String title, List<TypeVo> types) {
        this.title = title;
        this.types = types;
    }
    public void addtype(TypeVo n){
        types.add(n);
    }
    public void removetype(TypeVo o){
        types.remove(o);
    }
    public CategoryVo(String title) {
        this.title = title;
    }


}
