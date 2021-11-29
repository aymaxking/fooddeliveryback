package com.blackhole.fooddelivery.demo.domaine.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class MenuVo {
    private Long id;
    String title;
    private List<SubMenuVo> subMenus = new ArrayList<SubMenuVo>();


    public MenuVo(String title) {
        this.title = title;
    }

    public void addsubmenu(SubMenuVo subMenu){
        subMenus.add(subMenu);
    }
}
