package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.CategoryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.ClientVo;
import com.blackhole.fooddelivery.demo.model.Testclass;

import java.util.List;

public interface IClientService {
    ClientVo getById(Long id);
    List<ClientVo> getAll();
    List<ClientVo> getAllPagging(int page,int size);
    List<ClientVo> getAllByAll(String term);
    List<ClientVo> getAllByAllPagging(String term,int page,int size);
    void save(ClientVo client);
    void update(Long id,ClientVo client);
    void delete(Long id);
}
