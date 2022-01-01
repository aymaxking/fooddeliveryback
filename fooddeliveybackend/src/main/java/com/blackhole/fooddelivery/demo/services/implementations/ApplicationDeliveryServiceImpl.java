package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.dao.ApplicationDeliveryRepository;
import com.blackhole.fooddelivery.demo.dao.ClientRepository;
import com.blackhole.fooddelivery.demo.dao.TypeRepository;
import com.blackhole.fooddelivery.demo.domaine.converter.ApplicationDeliveryConverter;
import com.blackhole.fooddelivery.demo.domaine.converter.ClientConverter;
import com.blackhole.fooddelivery.demo.domaine.vo.ApplicationDeliveryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.ClientVo;
import com.blackhole.fooddelivery.demo.model.ApplicationDelivery;
import com.blackhole.fooddelivery.demo.model.Client;
import com.blackhole.fooddelivery.demo.services.IApplicationDeliveryService;
import com.blackhole.fooddelivery.demo.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("applicationDeliveryService")
@Transactional
public class ApplicationDeliveryServiceImpl implements IApplicationDeliveryService {
    @Autowired
    private ApplicationDeliveryRepository applicationDeliveryRepository;

    @Override
    public ApplicationDeliveryVo getById(Long id) {
        boolean trouve = applicationDeliveryRepository.existsById(id);
        if (!trouve)
            return null;
        return ApplicationDeliveryConverter.toVo(applicationDeliveryRepository.getById(id));
    }


    @Override
    public List<ApplicationDeliveryVo> getAll() {
        List<ApplicationDelivery> list = applicationDeliveryRepository.findAll();
        return ApplicationDeliveryConverter.toVoList(list);
    }

    @Override
    public List<ApplicationDeliveryVo> getAllPagging(int page, int size) {
        PageRequest pr = PageRequest.of(page, size);
        List<ApplicationDelivery> list = applicationDeliveryRepository.findAll(pr).getContent();
        return ApplicationDeliveryConverter.toVoList(list);
    }

    @Override
    public List<ApplicationDeliveryVo> getAllByAll(String term) {
        return ApplicationDeliveryConverter.toVoList(applicationDeliveryRepository.findByNameContainsOrEmailContains(term, term));
    }

    @Override
    public List<ApplicationDeliveryVo> getAllByAllPagging(String term, int page, int size) {
        PageRequest pr = PageRequest.of(page, size);
        List<ApplicationDelivery> list = applicationDeliveryRepository.findByNameContainsOrEmailContains(term, term, pr).getContent();
        return ApplicationDeliveryConverter.toVoList(list);
    }

    @Override
    public void save(ApplicationDeliveryVo applicationDelivery) {
        applicationDeliveryRepository.save(ApplicationDeliveryConverter.toBo(applicationDelivery));
    }

    @Override
    public void update(Long id, ApplicationDeliveryVo applicationDelivery) {
        applicationDelivery.setId(id);
        applicationDeliveryRepository.save(ApplicationDeliveryConverter.toBo(applicationDelivery));
    }

    @Override
    public void delete(Long id) {
        applicationDeliveryRepository.deleteById(id);
    }

}
