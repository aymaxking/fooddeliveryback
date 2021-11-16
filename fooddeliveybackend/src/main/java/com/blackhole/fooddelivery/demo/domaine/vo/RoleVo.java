package com.blackhole.fooddelivery.demo.domaine.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class RoleVo {
    private int id;
    private String role;

    public RoleVo(String role) {
        this.role = role;
    }
}
