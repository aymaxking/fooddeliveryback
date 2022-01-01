package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.ApplicationDeliveryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.ClientVo;

import java.util.List;

public interface IApplicationDeliveryService {
    ApplicationDeliveryVo getById(Long id);
    List<ApplicationDeliveryVo> getAll();
    List<ApplicationDeliveryVo> getAllPagging(int page,int size);
    List<ApplicationDeliveryVo> getAllByAll(String term);
    List<ApplicationDeliveryVo> getAllByAllPagging(String term,int page,int size);
    void save(ApplicationDeliveryVo applicationDelivery);
    void update(Long id,ApplicationDeliveryVo applicationDelivery);
    void delete(Long id);
}
