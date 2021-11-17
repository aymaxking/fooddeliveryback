package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.MenuVo;
import com.blackhole.fooddelivery.demo.domaine.vo.PlaceVo;

import java.util.List;

public interface IPLaceService {
    PlaceVo getById(Long id);
    List<PlaceVo> getAllPlaces();
    void save(PlaceVo place);
    void update(Long id,PlaceVo place);
    void delete(Long id);
}
