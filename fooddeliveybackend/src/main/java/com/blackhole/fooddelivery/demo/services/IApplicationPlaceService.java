package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.ApplicationDeliveryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.ApplicationPlaceVo;

import java.util.List;

public interface IApplicationPlaceService {
    ApplicationPlaceVo getById(Long id);
    List<ApplicationPlaceVo> getAll();
    List<ApplicationPlaceVo> getAllPagging(int page,int size);
    List<ApplicationPlaceVo> getAllByAll(String term);
    List<ApplicationPlaceVo> getAllByAllPagging(String term,int page,int size);
    void save(ApplicationPlaceVo applicationPlace);
    void update(Long id,ApplicationPlaceVo applicationPlace);
    void delete(Long id);
}
