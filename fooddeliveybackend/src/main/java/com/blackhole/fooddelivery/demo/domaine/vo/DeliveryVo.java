package com.blackhole.fooddelivery.demo.domaine.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class DeliveryVo extends UserVo {
    private String name;
    private String birthday;
    private String CIN;
    private String adresse;
     private String start_date;

}
