package com.blackhole.fooddelivery.demo.services;

import com.blackhole.fooddelivery.demo.domaine.vo.PlaceVo;
import com.blackhole.fooddelivery.demo.domaine.vo.RoleVo;

import java.util.List;

public interface IRoleService {
    RoleVo getById(Long id);
    List<RoleVo> getAllRoles();
    void save(RoleVo role);
    void update(Long id,RoleVo role);
    void delete(Long id);
}
