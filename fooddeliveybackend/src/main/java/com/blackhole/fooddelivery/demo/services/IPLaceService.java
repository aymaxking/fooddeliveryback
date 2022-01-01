package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.DeliveryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.MenuVo;
import com.blackhole.fooddelivery.demo.domaine.vo.PlaceVo;

import java.util.List;

public interface IPLaceService {
    PlaceVo getById(Long id);
    List<PlaceVo> getAll();
    List<PlaceVo> getAllPagging(int page, int size);
    List<PlaceVo> getAllByAll(String term);
    List<PlaceVo> getAllByAllPagging(String term,int page,int size);
    void save(PlaceVo place);
    void update(Long id,PlaceVo place);
    void delete(Long id);
    List<PlaceVo> findByTitle(String title);
    List<PlaceVo> findAll(int pageId, int size);
    List<PlaceVo> sortBy(String fieldName);
}
