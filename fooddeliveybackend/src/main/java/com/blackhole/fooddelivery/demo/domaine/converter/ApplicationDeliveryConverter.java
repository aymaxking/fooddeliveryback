package com.blackhole.fooddelivery.demo.domaine.converter;

import com.blackhole.fooddelivery.demo.domaine.vo.ApplicationDeliveryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.ApplicationVo;
import com.blackhole.fooddelivery.demo.model.Application;
import com.blackhole.fooddelivery.demo.model.ApplicationDelivery;

import java.util.ArrayList;
import java.util.List;

public class ApplicationDeliveryConverter {
    public static ApplicationDeliveryVo toVo(ApplicationDelivery bo) {
        if (bo == null)
            return null;
        ApplicationDeliveryVo vo = new ApplicationDeliveryVo();
        vo.setId(bo.getId());
        vo.setName(bo.getName());
        vo.setEmail(bo.getEmail());
        vo.setDate(bo.getDate());
        vo.setNumber(bo.getNumber());
        vo.setCity(bo.getCity());
        vo.setVehiculeType(bo.getVehiculeType());
        return vo;
    }
    public static ApplicationDelivery toBo(ApplicationDeliveryVo vo) {
        if (vo == null)
            return null;
        ApplicationDelivery bo = new ApplicationDelivery();
        if (vo.getId() != null)
            bo.setId(vo.getId());
        bo.setId(vo.getId());
        bo.setName(vo.getName());
        bo.setEmail(vo.getEmail());
        bo.setDate(vo.getDate());
        bo.setNumber(vo.getNumber());
        bo.setCity(vo.getCity());
        bo.setVehiculeType(vo.getVehiculeType());
        return bo;
    }
    public static List<ApplicationDeliveryVo> toVoList(List<ApplicationDelivery> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<ApplicationDeliveryVo> voList = new ArrayList<>();
        for (ApplicationDelivery applicationDelivery : boList) {
            voList.add(toVo(applicationDelivery));
        }
        return voList;
    }
    public static List<ApplicationDelivery> toBoList(List<ApplicationDeliveryVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<ApplicationDelivery> boList = new ArrayList<>();
        for (ApplicationDeliveryVo applicationDeliveryVo : voList) {
            boList.add(toBo(applicationDeliveryVo));
        }
        return boList;
    }
}