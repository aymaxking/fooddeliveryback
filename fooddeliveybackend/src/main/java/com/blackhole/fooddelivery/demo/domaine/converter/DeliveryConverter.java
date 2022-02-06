package com.blackhole.fooddelivery.demo.domaine.converter;

import com.blackhole.fooddelivery.demo.domaine.vo.DeliveryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.UserVo;
import com.blackhole.fooddelivery.demo.model.Delivery;
import com.blackhole.fooddelivery.demo.model.User;
import com.blackhole.fooddelivery.demo.services.IUserService;

import java.util.ArrayList;
import java.util.List;

public class DeliveryConverter  {
    public static DeliveryVo toVo(Delivery bo) {
        if (bo == null)
            return null;
        DeliveryVo vo = new DeliveryVo();
        vo.setId(bo.getId());
        vo.setUsername(bo.getUsername());
        vo.setPassword(bo.getPassword());
        vo.setImg(bo.getImg());
        vo.setAdresse(bo.getAdresse());
        vo.setCIN(bo.getCIN());
        vo.setName(bo.getName());
        vo.setStart_date(bo.getStart_date());
        vo.setBirthday(bo.getBirthday());
        vo.setRole(bo.getRole());
        vo.setImg(bo.getImg());
        return vo;
    }
    public static Delivery toBo(DeliveryVo vo) {
        if (vo == null)
            return null;
        Delivery bo = new Delivery();
        if (vo.getId() != null)
            bo.setId(vo.getId());
        bo.setUsername(vo.getUsername());
        bo.setPassword(vo.getPassword());
        bo.setImg(vo.getImg());
        bo.setRole(vo.getRole());
        bo.setAdresse(vo.getAdresse());
        bo.setCIN(vo.getCIN());
        bo.setName(vo.getName());
        bo.setStart_date(vo.getStart_date());
        bo.setBirthday(vo.getBirthday());
        bo.setImg(vo.getImg());
        return bo;
    }
    public static List<DeliveryVo> toVoList(List<Delivery> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<DeliveryVo> voList = new ArrayList<>();
        for (Delivery delivery : boList) {
            voList.add(toVo(delivery));
        }
        return voList;
    }
    public static List<Delivery> toBoList(List<DeliveryVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Delivery> boList = new ArrayList<>();
        for (DeliveryVo deliveryVo : voList) {
            boList.add(toBo(deliveryVo));
        }
        return boList;
    }
}