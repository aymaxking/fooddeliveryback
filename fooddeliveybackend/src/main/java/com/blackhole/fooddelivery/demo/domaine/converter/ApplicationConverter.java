package com.blackhole.fooddelivery.demo.domaine.converter;

import com.blackhole.fooddelivery.demo.domaine.vo.ApplicationVo;
import com.blackhole.fooddelivery.demo.domaine.vo.UserVo;
import com.blackhole.fooddelivery.demo.model.Application;
import com.blackhole.fooddelivery.demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class ApplicationConverter {
    public static ApplicationVo toVo(Application bo) {
        if (bo == null)
            return null;
        ApplicationVo vo = new ApplicationVo();
        vo.setId(bo.getId());
        vo.setName(bo.getName());
        vo.setEmail(bo.getEmail());
        vo.setDate(bo.getDate());
        vo.setNumber(bo.getNumber());
        vo.setEtat(bo.getEtat());
        return vo;
    }
    public static Application toBo(ApplicationVo vo) {
        if (vo == null)
            return null;
        Application bo = new Application();
        if (vo.getId() != null)
            bo.setId(vo.getId());
        bo.setId(vo.getId());
        bo.setName(vo.getName());
        bo.setEmail(vo.getEmail());
        bo.setDate(vo.getDate());
        bo.setNumber(vo.getNumber());
        bo.setEtat(vo.getEtat());
        return bo;
    }
    public static List<ApplicationVo> toVoList(List<Application> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<ApplicationVo> voList = new ArrayList<>();
        for (Application application : boList) {
            voList.add(toVo(application));
        }
        return voList;
    }
    public static List<Application> toBoList(List<ApplicationVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Application> boList = new ArrayList<>();
        for (ApplicationVo applicationVo : voList) {
            boList.add(toBo(applicationVo));
        }
        return boList;
    }
}