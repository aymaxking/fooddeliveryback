package com.blackhole.fooddelivery.demo.model;

import com.blackhole.fooddelivery.demo.domaine.vo.SubMenuVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "place")
@NoArgsConstructor
@Entity
@DiscriminatorValue("P")
public class Place extends User{
    @Column(name = "place")
    String title;
    String location;
    @Lob
    byte[] img;
    String description;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="place_id", nullable=false)
    private List<Menu> menus = new ArrayList<Menu>();

    public boolean containsItem(SubMenu subMenu){
        for(Menu m:menus){
            for(SubMenu s:m.getSubMenus()){
                if(s.getId()==subMenu.getId()) return true;
            }
        }
        return false;

    }

    public Place(String title, byte[] img, String description) {
        this.title = title;
        this.img = img;
        this.description = description;
    }
}
