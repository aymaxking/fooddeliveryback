package com.blackhole.fooddelivery.demo.domaine.converter;

import com.blackhole.fooddelivery.demo.domaine.vo.LocationVo;
import com.blackhole.fooddelivery.demo.domaine.vo.MenuVo;
import com.blackhole.fooddelivery.demo.model.Location;
import com.blackhole.fooddelivery.demo.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class LocationConverter {
    public static LocationVo toVo(Location bo) {
        if (bo == null)
            return null;
        LocationVo vo = new LocationVo();
        vo.setId(bo.getId());
        vo.setLocation(bo.getLocation());
        return vo;
    }

    public static Location toBo(LocationVo vo) {
        if (vo == null)
            return null;
        Location bo = new Location();
        bo.setId(vo.getId());
        bo.setLocation(vo.getLocation());
        return bo;
    }

    public static List<LocationVo> toVoList(List<Location> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<LocationVo> voList = new ArrayList<>();
        for (Location location : boList) {
            voList.add(toVo(location));
        }
        return voList;
    }

    public static List<Location> toBoList(List<LocationVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Location> boList = new ArrayList<>();
        for (LocationVo locationVo : voList) {
            boList.add(toBo(locationVo));
        }
        return boList;
    
    }
}