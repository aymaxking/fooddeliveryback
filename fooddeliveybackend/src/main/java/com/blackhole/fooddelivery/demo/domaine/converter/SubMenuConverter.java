package com.blackhole.fooddelivery.demo.domaine.converter;

import com.blackhole.fooddelivery.demo.domaine.vo.SubMenuVo;
import com.blackhole.fooddelivery.demo.model.SubMenu;

import java.util.ArrayList;
import java.util.List;

public class SubMenuConverter {
    public static SubMenuVo toVo(SubMenu bo) {
        if (bo == null)
            return null;
        SubMenuVo vo = new SubMenuVo();
        vo.setId(bo.getId());
        vo.setImg(bo.getImg());
        vo.setPrice(bo.getPrice());
        vo.setTitle(bo.getTitle());
        vo.setMenu(MenuConverter.toVo(bo.getMenu()));
        return vo;
    }
    public static SubMenu toBo(SubMenuVo vo) {
        if (vo == null)
            return null;
        SubMenu bo = new SubMenu();
        bo.setId(vo.getId());
        bo.setImg(vo.getImg());
        bo.setPrice(vo.getPrice());
        bo.setTitle(vo.getTitle());
        bo.setMenu(MenuConverter.toBo(vo.getMenu()));
        return bo;
    }
    public static List<SubMenuVo> toVoList(List<SubMenu> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<SubMenuVo> voList = new ArrayList<>();
        for (SubMenu subMenu : boList) {
            voList.add(toVo(subMenu));
        }
        return voList;
    }
    public static List<SubMenu> toBoList(List<SubMenuVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<SubMenu> boList = new ArrayList<>();
        for (SubMenuVo subMenuVo: voList) {
            boList.add(toBo(subMenuVo));
        }
        return boList;
    }
}