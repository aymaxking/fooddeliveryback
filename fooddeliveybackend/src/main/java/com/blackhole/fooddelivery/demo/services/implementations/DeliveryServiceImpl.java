package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.dao.ClientRepository;
import com.blackhole.fooddelivery.demo.dao.DeliveryRepository;
import com.blackhole.fooddelivery.demo.dao.TypeRepository;
import com.blackhole.fooddelivery.demo.domaine.converter.ClientConverter;
import com.blackhole.fooddelivery.demo.domaine.converter.DeliveryConverter;
import com.blackhole.fooddelivery.demo.domaine.vo.ClientVo;
import com.blackhole.fooddelivery.demo.domaine.vo.DeliveryVo;
import com.blackhole.fooddelivery.demo.model.Client;
import com.blackhole.fooddelivery.demo.model.Delivery;
import com.blackhole.fooddelivery.demo.services.IClientService;
import com.blackhole.fooddelivery.demo.services.IDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("deliveryService")
@Transactional
public class DeliveryServiceImpl implements IDeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public DeliveryVo getById(Long id) {
        boolean trouve = deliveryRepository.existsById(id);
        if (!trouve)
            return null;
        return DeliveryConverter.toVo(deliveryRepository.getById(id));
    }

    @Override
    public DeliveryVo getDispo() {
        return  DeliveryConverter.toVo(deliveryRepository.findAll().get(0));
    }


    @Override
    public List<DeliveryVo> getAll() {
        List<Delivery> list = deliveryRepository.findAll();
        return DeliveryConverter.toVoList(list);
    }

    @Override
    public List<DeliveryVo> getAllPagging(int page, int size) {
        PageRequest pr = PageRequest.of(page, size);
        List<Delivery> list = deliveryRepository.findAll(pr).getContent();
        return DeliveryConverter.toVoList(list);
    }

    @Override
    public List<DeliveryVo> getAllByAll(String term) {
        return DeliveryConverter.toVoList(deliveryRepository.findByUsernameContainsOrNameContainsOrCINContains(term, term, term));
    }

    @Override
    public List<DeliveryVo> getAllByAllPagging(String term, int page, int size) {
        PageRequest pr = PageRequest.of(page, size);
        List<Delivery> list = deliveryRepository.findByUsernameContainsOrNameContainsOrCINContains(term, term, term, pr).getContent();
        return DeliveryConverter.toVoList(list);
    }

    @Override
    public void save(DeliveryVo delivery) {
        deliveryRepository.save(DeliveryConverter.toBo(delivery));
    }

    @Override
    public void update(Long id, DeliveryVo delivery) {
        delivery.setId(id);
        deliveryRepository.save(DeliveryConverter.toBo(delivery));
    }

    @Override
    public void delete(Long id) {
        deliveryRepository.deleteById(id);
    }

}
