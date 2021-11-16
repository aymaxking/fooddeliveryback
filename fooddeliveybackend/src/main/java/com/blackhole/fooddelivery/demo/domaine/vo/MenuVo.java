package com.blackhole.fooddelivery.demo.domaine.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class MenuVo {
    private Long id;
    String title;

    public MenuVo(String title) {
        this.title = title;
    }
}
