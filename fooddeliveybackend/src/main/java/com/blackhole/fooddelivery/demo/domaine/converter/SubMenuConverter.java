package com.blackhole.fooddelivery.demo.domaine.converter;

import com.blackhole.fooddelivery.demo.domaine.vo.RoleVo;
import com.blackhole.fooddelivery.demo.service.model.*;

import java.util.ArrayList;
import java.util.List;

public class SubMenuConverter {
    public static RoleVo toVo(SubMenu bo) {
        if (bo == null)
            return null;
        SubMenu vo = new SubMenu();
        vo.setId(bo.getId());
        vo.setRole(bo.getRole());
        return vo;
    }
    public static Role toBo(RoleVo vo) {
        if (vo == null)
            return null;
        Role bo = new Role();
        bo.setId(vo.getId());
        bo.setRole(vo.getRole());
        return bo;
    }
    public static List<RoleVo> toVoList(List<Role> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<RoleVo> voList = new ArrayList<>();
        for (Role role : boList) {
            voList.add(toVo(role));
        }
        return voList;
    }
    public static List<Role> toBoList(List<RoleVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Role> boList = new ArrayList<>();
        for (RoleVo roleVo : voList) {
            boList.add(toBo(roleVo));
        }
        return boList;
    }
}