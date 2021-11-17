package com.blackhole.fooddelivery.demo.domaine.converter;

import com.blackhole.fooddelivery.demo.domaine.vo.RoleVo;
import com.blackhole.fooddelivery.demo.domaine.vo.TypeVo;
import com.blackhole.fooddelivery.demo.service.model.Role;
import com.blackhole.fooddelivery.demo.service.model.Type;

import java.util.ArrayList;
import java.util.List;

public class TypeConverter {
    public static TypeVo toVo(Type bo) {
        if (bo == null)
            return null;
        TypeVo vo = new TypeVo();
        vo.setId(bo.getId());
        vo.setTitle(bo.getTitle());
        vo.setIcon(bo.getIcon());
        return vo;
    }
    public static Type toBo(TypeVo vo) {
        if (vo == null)
            return null;
        Type bo = new Type();
        bo.setId(vo.getId());
        bo.setTitle(vo.getTitle());
        bo.setIcon(vo.getIcon());
        return bo;
    }
    public static List<TypeVo> toVoList(List<Type> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<TypeVo> voList = new ArrayList<>();
        for (Type Type : boList) {
            voList.add(toVo(Type));
        }
        return voList;
    }
    public static List<Type> toBoList(List<TypeVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Type> boList = new ArrayList<>();
        for (TypeVo typeVo: voList) {
            boList.add(toBo(typeVo));
        }
        return boList;
    }
}