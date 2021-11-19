package com.blackhole.fooddelivery.demo.domaine.converter;

import com.blackhole.fooddelivery.demo.domaine.vo.MenuVo;
import com.blackhole.fooddelivery.demo.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuConverter {
    public static MenuVo toVo(Menu bo) {
        if (bo == null)
            return null;
        MenuVo vo = new MenuVo();
        vo.setId(bo.getId());
        vo.setTitle(bo.getTitle());
        return vo;
    }

    public static Menu toBo(MenuVo vo) {
        if (vo == null)
            return null;
        Menu bo = new Menu();
        bo.setId(vo.getId());
        bo.setTitle(vo.getTitle());
        return bo;
    }

    public static List<MenuVo> toVoList(List<Menu> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<MenuVo> voList = new ArrayList<>();
        for (Menu menu : boList) {
            voList.add(toVo(menu));
        }
        return voList;
    }

    public static List<Menu> toBoList(List<MenuVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Menu> boList = new ArrayList<>();
        for (MenuVo menuVo : voList) {
            boList.add(toBo(menuVo));
        }
        return boList;
    
    }
}