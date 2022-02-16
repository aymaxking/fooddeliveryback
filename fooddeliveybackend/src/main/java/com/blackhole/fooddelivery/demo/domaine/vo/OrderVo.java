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
public class OrderVo {
    private Long id;
    private String date;
    private String heure;
    private String etat;
    private ClientVo client;
    private DeliveryVo delivery;
    private Long idclient;
    private List<SubMenuVo> items = new ArrayList<SubMenuVo>();
}
