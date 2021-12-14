package com.blackhole.fooddelivery.demo.domaine.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class LocationVo {
    private Long id;
    String location;

    public LocationVo(String location) {
        this.location = location;
    }
}
