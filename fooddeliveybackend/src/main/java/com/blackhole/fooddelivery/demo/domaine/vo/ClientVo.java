package com.blackhole.fooddelivery.demo.domaine.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ClientVo extends UserVo {
    private String name;
    private String birthday;
    private String CIN;
    private String home_adresse;


    public ClientVo(String username, String password, String role, String name, String birthday, String CIN, String home_adresse) {
        super(username, password, role);
        this.name = name;
        this.birthday = birthday;
        this.CIN = CIN;
        this.home_adresse = home_adresse;
    }
}
