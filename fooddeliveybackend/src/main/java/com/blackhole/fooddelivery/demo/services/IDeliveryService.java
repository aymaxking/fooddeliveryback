package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.ClientVo;
import com.blackhole.fooddelivery.demo.domaine.vo.DeliveryVo;

import java.util.List;

public interface IDeliveryService {
    DeliveryVo getById(Long id);
    DeliveryVo getDispo();
    List<DeliveryVo> getAll();
    List<DeliveryVo> getAllPagging(int page,int size);
    List<DeliveryVo> getAllByAll(String term);
    List<DeliveryVo> getAllByAllPagging(String term,int page,int size);
    void save(DeliveryVo delivery);
    void update(Long id,DeliveryVo delivery);
    void delete(Long id);
}
