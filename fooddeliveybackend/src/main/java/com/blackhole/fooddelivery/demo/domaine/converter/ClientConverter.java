package com.blackhole.fooddelivery.demo.domaine.converter;

import com.blackhole.fooddelivery.demo.domaine.vo.ClientVo;
import com.blackhole.fooddelivery.demo.domaine.vo.DeliveryVo;
import com.blackhole.fooddelivery.demo.model.Client;
import com.blackhole.fooddelivery.demo.model.Delivery;
import com.blackhole.fooddelivery.demo.services.IUserService;

import java.util.ArrayList;
import java.util.List;

public class ClientConverter  {
    public static ClientVo toVo(Client bo) {
        if (bo == null)
            return null;
        ClientVo vo = new ClientVo();
        vo.setId(bo.getId());
        vo.setUsername(bo.getUsername());
        vo.setPassword(bo.getPassword());
        vo.setHome_adresse(bo.getHome_adresse());
        vo.setCIN(bo.getCIN());
        vo.setName(bo.getName());
        vo.setBirthday(bo.getBirthday());
        return vo;
    }
    public static Client toBo(ClientVo vo) {
        if (vo == null)
            return null;
        Client bo = new Client();
        if (vo.getId() != null)
            bo.setId(vo.getId());
        bo.setUsername(vo.getUsername());
        bo.setPassword(vo.getPassword());
        bo.setHome_adresse(vo.getHome_adresse());
        bo.setCIN(vo.getCIN());
        bo.setName(vo.getName());
        bo.setBirthday(vo.getBirthday());
        return bo;
    }
    public static List<ClientVo> toVoList(List<Client> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<ClientVo> voList = new ArrayList<>();
        for (Client client : boList) {
            voList.add(toVo(client));
        }
        return voList;
    }
    public static List<Client> toBoList(List<ClientVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Client> boList = new ArrayList<>();
        for (ClientVo clientVo : voList) {
            boList.add(toBo(clientVo));
        }
        return boList;
    }
}