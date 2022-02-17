package com.blackhole.fooddelivery.demo.domaine.converter;

import com.blackhole.fooddelivery.demo.domaine.vo.CommandeVo;
import com.blackhole.fooddelivery.demo.model.Commande;

import java.util.ArrayList;
import java.util.List;

public class CommandeConverter {
    public static CommandeVo toVo(Commande bo) {
        if (bo == null)
            return null;
        CommandeVo vo = new CommandeVo();
        vo.setId(bo.getId());
        vo.setEtat(bo.getEtat());
        vo.setDate(bo.getDate());
        vo.setClient(ClientConverter.toVo(bo.getClient()));
        vo.setDelivery(DeliveryConverter.toVo(bo.getDelivery()));
        vo.setHeure(bo.getHeure());
        vo.setItems(SubMenuConverter.toVoList(bo.getItems()));
        return vo;
    }
    public static Commande toBo(CommandeVo vo) {
        if (vo == null)
            return null;
        Commande bo = new Commande();
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
    public static List<CommandeVo> toVoList(List<Commande> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<CommandeVo> voList = new ArrayList<>();
        for (Commande commande : boList) {
            voList.add(toVo(commande));
        }
        return voList;
    }
    public static List<Commande> toBoList(List<CommandeVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Commande> boList = new ArrayList<>();
        for (CommandeVo commandeVo : voList) {
            boList.add(toBo(commandeVo));
        }
        return boList;
    }
}