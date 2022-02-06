package com.blackhole.fooddelivery.demo.domaine.converter;

import com.blackhole.fooddelivery.demo.domaine.vo.ApplicationDeliveryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.ApplicationPlaceVo;
import com.blackhole.fooddelivery.demo.model.ApplicationDelivery;
import com.blackhole.fooddelivery.demo.model.ApplicationPlace;

import java.util.ArrayList;
import java.util.List;

public class ApplicationPlaceConverter {
    public static ApplicationPlaceVo toVo(ApplicationPlace bo) {
        if (bo == null)
            return null;
        ApplicationPlaceVo vo = new ApplicationPlaceVo();
        vo.setId(bo.getId());
        vo.setName(bo.getName());
        vo.setEmail(bo.getEmail());
        vo.setDate(bo.getDate());
        vo.setNumber(bo.getNumber());
        vo.setDescription(bo.getDescription());
        vo.setEtat(bo.getEtat());
        vo.setImg(bo.getImg());
        return vo;
    }
    public static ApplicationPlace toBo(ApplicationPlaceVo vo) {
        if (vo == null)
            return null;
        ApplicationPlace bo = new ApplicationPlace();
        if (vo.getId() != null)
            bo.setId(vo.getId());
        bo.setId(vo.getId());
        bo.setName(vo.getName());
        bo.setEmail(vo.getEmail());
        bo.setDate(vo.getDate());
        bo.setNumber(vo.getNumber());
        bo.setDescription(vo.getDescription());
        bo.setEtat(vo.getEtat());
        bo.setImg(vo.getImg());
        return bo;
    }
    public static List<ApplicationPlaceVo> toVoList(List<ApplicationPlace> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<ApplicationPlaceVo> voList = new ArrayList<>();
        for (ApplicationPlace applicationPlace : boList) {
            voList.add(toVo(applicationPlace));
        }
        return voList;
    }
    public static List<ApplicationPlace> toBoList(List<ApplicationPlaceVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<ApplicationPlace> boList = new ArrayList<>();
        for (ApplicationPlaceVo applicationPlaceVo : voList) {
            boList.add(toBo(applicationPlaceVo));
        }
        return boList;
    }
}