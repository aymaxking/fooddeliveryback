package com.blackhole.fooddelivery.demo.domaine.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
public class DeliveryVo extends UserVo {
    private String name;
    private String birthday;
    private String CIN;
    private String adresse;
    private String start_date;


    public DeliveryVo(String username, String password, List<RoleVo> roles, String name, String birthday, String CIN, String adresse, String start_date) {
        super(username, password, roles);
        this.name = name;
        this.birthday = birthday;
        this.CIN = CIN;
        this.adresse = adresse;
        this.start_date = start_date;
    }
    public DeliveryVo(ApplicationDeliveryVo vo) {
        this.name = vo.getName();
        this.birthday = vo.getBirthday();
        this.CIN = vo.getCin();
        this.adresse=vo.getAdresse();
        this.start_date=new Date().toString();
        this.setUsername(vo.getEmail());
        this.setPassword("password");
    }
}
