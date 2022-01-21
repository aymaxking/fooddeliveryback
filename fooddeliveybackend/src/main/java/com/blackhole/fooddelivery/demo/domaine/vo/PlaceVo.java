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
public class PlaceVo  extends UserVo{
    String title;
    @Lob
    byte[] img;
    String description;
    private List<MenuVo> menus = new ArrayList<MenuVo>();
    private List<LocationVo> locations = new ArrayList<LocationVo>();


    public PlaceVo(String username, String password,  String title, byte[] img, String description) {
        super(username, password);
        this.title = title;
        this.img = img;
        this.description = description;
    }

    public PlaceVo(String title, byte[] img, String description, String username, String password) {
        this.title = title;
        this.img = img;
        this.description = description;
        this.setUsername(username);
        this.setPassword(password);
    }

    public PlaceVo(ApplicationPlaceVo vo) {
        this.title = vo.getName();
        this.img = null;
        this.description = vo.getDescription();
        this.setUsername(vo.getEmail());
        this.setPassword("password");

    }
    public void addmenu(MenuVo menu){
        menus.add(menu);
    }
    public void addlocation(LocationVo location){
        locations.add(location);
    }
    public void removemenu(MenuVo menu){
        menus.remove(menu);
    }
    public MenuVo findmenubyid(Long id){
        for(MenuVo menu : menus){
            if(menu.getId()==id) return menu;
        }
        return null;
    }
}
