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
    private PlaceVo place;
    private List<SubMenuVo> subMenus = new ArrayList<SubMenuVo>();
    public void addsubmenu(SubMenuVo n){
        subMenus.add(n);
        n.setMenu(this);
    }
    public void removesubmenu(SubMenuVo o){
        subMenus.remove(o);
        o.setMenu(null);
    }
    public MenuVo(String title) {
        this.title = title;
    }

}
