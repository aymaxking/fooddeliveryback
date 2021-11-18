package com.blackhole.fooddelivery.demo.domaine.converter;

import com.blackhole.fooddelivery.demo.domaine.vo.PlaceVo;
import com.blackhole.fooddelivery.demo.domaine.vo.RoleVo;
import com.blackhole.fooddelivery.demo.domaine.vo.SubMenuVo;
import com.blackhole.fooddelivery.demo.service.model.Place;
import com.blackhole.fooddelivery.demo.service.model.Role;
import com.blackhole.fooddelivery.demo.service.model.SubMenu;

import java.util.ArrayList;
import java.util.List;

public class PlaceConverter {
    public static PlaceVo toVo(Place bo) {
        if (bo == null)
            return null;
        PlaceVo vo = new PlaceVo();
        vo.setId(bo.getId());
        vo.setDescription(bo.getDescription());
        vo.setImg(bo.getImg());
        vo.setTitle(bo.getTitle());
        return vo;
    }
    public static Place toBo(PlaceVo vo) {
        if (vo == null)
            return null;
        Place bo = new Place();
        bo.setId(vo.getId());
        bo.setDescription(vo.getDescription());
        bo.setImg(vo.getImg());
        bo.setTitle(vo.getTitle());
        return bo;
    }
    public static List<PlaceVo> toVoList(List<Place> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<PlaceVo> voList = new ArrayList<>();
        for (Place place : boList) {
            voList.add(toVo(place));
        }
        return voList;
    }
    public static List<Place> toBoList(List<PlaceVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Place> boList = new ArrayList<>();
        for (PlaceVo placeVo: voList) {
            boList.add(toBo(placeVo));
        }
        return boList;
    }
}