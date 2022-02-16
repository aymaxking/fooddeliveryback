package com.blackhole.fooddelivery.demo.domaine.converter;

import com.blackhole.fooddelivery.demo.domaine.vo.ApplicationVo;
import com.blackhole.fooddelivery.demo.domaine.vo.OrderVo;
import com.blackhole.fooddelivery.demo.model.Application;
import com.blackhole.fooddelivery.demo.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {
    public static OrderVo toVo(Order bo) {
        if (bo == null)
            return null;
        OrderVo vo = new OrderVo();
        vo.setId(bo.getId());
        vo.setEtat(bo.getEtat());
        vo.setDate(bo.getDate());
        vo.setClient(ClientConverter.toVo(bo.getClient()));
        vo.setDelivery(DeliveryConverter.toVo(bo.getDelivery()));
        vo.setHeure(bo.getHeure());
        vo.setItems(SubMenuConverter.toVoList(bo.getItems()));
        return vo;
    }
    public static Order toBo(OrderVo vo) {
        if (vo == null)
            return null;
        Order bo = new Order();
        if (vo.getId() != null)
            bo.setId(vo.getId());
        bo.setId(vo.getId());
        bo.setEtat(vo.getEtat());
        bo.setDate(vo.getDate());
        bo.setClient(ClientConverter.toBo(vo.getClient()));
        bo.setDelivery(DeliveryConverter.toBo(vo.getDelivery()));
        bo.setHeure(bo.getHeure());
        bo.setItems(SubMenuConverter.toBoList(vo.getItems()));
        return bo;
    }
    public static List<OrderVo> toVoList(List<Order> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<OrderVo> voList = new ArrayList<>();
        for (Order order : boList) {
            voList.add(toVo(order));
        }
        return voList;
    }
    public static List<Order> toBoList(List<OrderVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Order> boList = new ArrayList<>();
        for (OrderVo orderVo : voList) {
            boList.add(toBo(orderVo));
        }
        return boList;
    }
}