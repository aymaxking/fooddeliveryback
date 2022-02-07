package com.blackhole.fooddelivery.demo.domaine.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApplicationPlaceVo extends ApplicationVo {
    private String description;
    private String location;

}
