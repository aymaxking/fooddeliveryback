package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.CategoryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.MenuVo;

import java.util.List;

public interface IMenuService {
    MenuVo getById(Long id);
    List<MenuVo> getAll();
    void save(MenuVo menu);
    void update(Long id,MenuVo menu);
    void delete(Long id);
}
