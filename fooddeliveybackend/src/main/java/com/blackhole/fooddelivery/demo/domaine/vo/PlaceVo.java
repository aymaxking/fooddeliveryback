package com.blackhole.fooddelivery.demo.domaine.vo;

import com.blackhole.fooddelivery.demo.FoodDeliveryApplication;
import com.blackhole.fooddelivery.demo.model.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    String location;
    private List<MenuVo> menus = new ArrayList<MenuVo>();


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
        this.location=vo.getLocation();
        this.img=vo.img;
        this.setUsername(vo.getEmail());
        this.setPassword(FoodDeliveryApplication.GenerateRandomPassword());
        this.setRole("place");



    }
    public void addmenu(MenuVo menu){
        if(menus==null) menus=new ArrayList<MenuVo>();
        menus.add(menu);
    }
    public MenuVo findmenubyid(Long id){
        for(MenuVo menu : menus){
            if(menu.getId()==id) return menu;
        }
        return null;
    }

}
