package com.blackhole.fooddelivery.demo.domaine.vo;

import com.blackhole.fooddelivery.demo.model.Client;
import com.blackhole.fooddelivery.demo.model.Delivery;
import com.blackhole.fooddelivery.demo.model.SubMenu;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class CommandeVo {
    private Long id;
    private String date;
    private String heure;
    private String etat;
    private double total;
    private ClientVo client;
    private DeliveryVo delivery;
    private Long idclient;
    private Long iddelivery;
    private List<SubMenuVo> items = new ArrayList<SubMenuVo>();



    public double getTotal() {
        double t = 0;
        if(items!=null)
        for(SubMenuVo item : items){
            t=item.getPrice();
        }
        return t;
    }
}
