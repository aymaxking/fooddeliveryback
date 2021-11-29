package com.blackhole.fooddelivery.demo.domaine.vo;

import com.blackhole.fooddelivery.demo.model.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PlaceVo {
    private Long id;
    String title;
    @Lob
    byte[] img;
    String description;
    private List<MenuVo> menus = new ArrayList<MenuVo>();


    public PlaceVo(String title, byte[] img, String description) {
        this.title = title;
        this.img = img;
        this.description = description;
    }
    public void addmenu(MenuVo menu){
        menus.add(menu);
    }
}
