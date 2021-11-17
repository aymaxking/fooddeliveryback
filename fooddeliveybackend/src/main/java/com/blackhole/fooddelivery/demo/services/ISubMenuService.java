package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.RoleVo;
import com.blackhole.fooddelivery.demo.domaine.vo.SubMenuVo;

import java.util.List;

public interface ISubMenuService {
    SubMenuVo getById(Long id);
    List<SubMenuVo> getAllSubMenu();
    void save(SubMenuVo subMenu);
    void update(Long id,SubMenuVo subMenu);
    void delete(Long id);
}
