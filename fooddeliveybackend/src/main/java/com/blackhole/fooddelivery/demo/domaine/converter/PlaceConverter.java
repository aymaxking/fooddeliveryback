package com.blackhole.fooddelivery.demo.domaine.converter;

import com.blackhole.fooddelivery.demo.domaine.vo.PlaceVo;
import com.blackhole.fooddelivery.demo.model.Place;

import java.util.ArrayList;
import java.util.List;

public class PlaceConverter {
    public static PlaceVo toVo(Place bo) {
        if (bo == null)
            return null;
        PlaceVo vo = new PlaceVo();
        vo.setId(bo.getId());
        vo.setUsername(bo.getUsername());
        vo.setPassword(bo.getPassword());
        vo.setDescription(bo.getDescription());
        vo.setImg(bo.getImg());
        vo.setTitle(bo.getTitle());
        vo.setMenus(MenuConverter.toVoList(bo.getMenus()));
        vo.setLocations(LocationConverter.toVoList(bo.getLocations()));
        return vo;
    }
    public static Place toBo(PlaceVo vo) {
        if (vo == null)
            return null;
        Place bo = new Place();
        bo.setId(vo.getId());
        bo.setDescription(vo.getDescription());
        bo.setUsername(vo.getUsername());
        bo.setPassword(vo.getPassword());
        bo.setImg(vo.getImg());
        bo.setTitle(vo.getTitle());
        bo.setMenus(MenuConverter.toBoList(vo.getMenus()));
        bo.setLocations(LocationConverter.toBoList(vo.getLocations()));
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