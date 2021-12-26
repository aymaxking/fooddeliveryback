package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.dao.CategoryRepository;
import com.blackhole.fooddelivery.demo.dao.ClientRepository;
import com.blackhole.fooddelivery.demo.dao.TypeRepository;
import com.blackhole.fooddelivery.demo.domaine.converter.CategoryConverter;
import com.blackhole.fooddelivery.demo.domaine.converter.ClientConverter;
import com.blackhole.fooddelivery.demo.domaine.vo.CategoryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.ClientVo;
import com.blackhole.fooddelivery.demo.model.Category;
import com.blackhole.fooddelivery.demo.model.Client;
import com.blackhole.fooddelivery.demo.model.Testclass;
import com.blackhole.fooddelivery.demo.services.ICategoryService;
import com.blackhole.fooddelivery.demo.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements IClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public ClientVo getById(Long id) {
        boolean trouve = clientRepository.existsById(id);
        if (!trouve)
            return null;
        return ClientConverter.toVo(clientRepository.getById(id));
    }



    @Override
    public List<ClientVo> getAll() {
        List<Client> list = clientRepository.findAll();
        return ClientConverter.toVoList(list);
    }

    @Override
    public List<ClientVo> getAllPagging(int page, int size) {
        PageRequest pr = PageRequest.of(page,size);
        List<Client> list = clientRepository.findAll(pr).getContent();
        return ClientConverter.toVoList(list);
    }

    @Override
    public List<ClientVo> getAllByAll(String term) {
        return ClientConverter.toVoList(clientRepository.findByUsernameContainsOrNameContainsOrCINContains(term,term,term));
    }

    @Override
    public List<ClientVo> getAllByAllPagging(String term, int page, int size) {
        PageRequest pr = PageRequest.of(page,size);
        List<Client> list = clientRepository.findByUsernameContainsOrNameContainsOrCINContains(term,term,term,pr).getContent();
        return ClientConverter.toVoList(list);    }

    @Override
    public void save(ClientVo client) {
        clientRepository.save(ClientConverter.toBo(client));
    }

    @Override
    public void update(Long id, ClientVo client) {
        client.setId(id);
        clientRepository.save(ClientConverter.toBo(client));
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

}
