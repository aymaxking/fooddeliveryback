package com.blackhole.fooddelivery.demo.domaine.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserVo {
    private Long id;
    private String username;
    private String password;
    private String role;
    @Lob
    byte[] img;

    public UserVo(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public UserVo(String username, String password) {
        this.username = username;
        this.password = password;
    }
}