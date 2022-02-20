package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.*;

import java.util.List;

public interface ICommandeService {
    CommandeVo getById(Long id);
    List<CommandeVo> getByClient(Long id);
    List<CommandeVo> getByDelivery(Long id);
    List<CommandeVo> getAll();
    List<CommandeVo> getAllPagging(int page, int size);
    void save(CommandeVo order);
    void update(Long id, CommandeVo order);
    void delete(Long id);
}