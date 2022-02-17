package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.dao.CommandeRepository;
import com.blackhole.fooddelivery.demo.domaine.converter.CommandeConverter;
import com.blackhole.fooddelivery.demo.domaine.vo.CommandeVo;
import com.blackhole.fooddelivery.demo.model.Commande;
import com.blackhole.fooddelivery.demo.services.IClientService;
import com.blackhole.fooddelivery.demo.services.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<CommandeVo> getAll() {
        List<Commande> list = commandeRepository.findAll();
        return CommandeConverter.toVoList(list);
    }

    @Override
    public List<CommandeVo> getAllPagging(int page, int size) {
        PageRequest pr = PageRequest.of(page,size);
        List<Commande> list = commandeRepository.findAll(pr).getContent();
        return CommandeConverter.toVoList(list);
    }



    @Override
    public void save(CommandeVo order) {
        order.setClient(clientService.getById(order.getIdclient()));
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
