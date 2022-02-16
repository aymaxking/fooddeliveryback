package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.*;
import com.blackhole.fooddelivery.demo.model.Testclass;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IOrderService{
    OrderVo getById(Long id);
    List<OrderVo> getAll();
    List<OrderVo> getAllPagging(int page,int size);
    void save(OrderVo order);
    void update(Long id,OrderVo order);
    void delete(Long id);
}