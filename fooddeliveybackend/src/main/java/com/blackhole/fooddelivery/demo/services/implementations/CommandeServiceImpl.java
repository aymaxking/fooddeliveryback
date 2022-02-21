package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.dao.CommandeRepository;
import com.blackhole.fooddelivery.demo.domaine.converter.CommandeConverter;
import com.blackhole.fooddelivery.demo.domaine.vo.CommandeVo;
import com.blackhole.fooddelivery.demo.domaine.vo.SubMenuVo;
import com.blackhole.fooddelivery.demo.model.Commande;
import com.blackhole.fooddelivery.demo.model.SubMenu;
import com.blackhole.fooddelivery.demo.services.IClientService;
import com.blackhole.fooddelivery.demo.services.ICommandeService;
import com.blackhole.fooddelivery.demo.utils.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("orderService")
@Transactional
public class CommandeServiceImpl implements ICommandeService {
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private IClientService clientService;


    @Override
    public CommandeVo getById(Long id) {
        boolean trouve = commandeRepository.existsById(id);
        if (!trouve)
            return null;
        return CommandeConverter.toVo(commandeRepository.getById(id));
    }

    @Override
    public List<CommandeVo> getByClient(Long id) {
        List<Commande> list = commandeRepository.findAllByIdclient(id);
//        for (Commande c : list) {
//            for (SubMenu i : c.getItems()) {
//                i.setImg(ImageUtility.decompressImage(i.getImg()));
//            }
//        }
        return CommandeConverter.toVoList(list);
    }

    @Override
    public List<CommandeVo> getByDelivery(Long id) {
        List<Commande> list = commandeRepository.findAllByIddelivery(id);
        return CommandeConverter.toVoList(list);
    }


    @Override
    public List<CommandeVo> getAll() {
        List<Commande> list = commandeRepository.findAll();
        return CommandeConverter.toVoList(list);
    }

    @Override
    public List<CommandeVo> getAllPagging(int page, int size) {
        PageRequest pr = PageRequest.of(page, size);
        List<Commande> list = commandeRepository.findAll(pr).getContent();
        return CommandeConverter.toVoList(list);
    }


    @Override
    public void save(CommandeVo order) {
        order.setClient(clientService.getById(order.getIdclient()));
        order.setDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        order.setHeure(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));
        order.setEtat("En attente du paiement");
        for (SubMenuVo i : order.getItems()) {
            i.setImg(ImageUtility.compressImage(i.getImg()));
        }
        commandeRepository.save(CommandeConverter.toBo(order));
    }

    @Override
    public void update(Long id, CommandeVo order) {
        order.setId(id);
        commandeRepository.save(CommandeConverter.toBo(order));
    }

    @Override
    public void delete(Long id) {
        commandeRepository.deleteById(id);
    }

}
