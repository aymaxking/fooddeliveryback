package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.dao.ApplicationDeliveryRepository;
import com.blackhole.fooddelivery.demo.dao.ApplicationPlaceRepository;
import com.blackhole.fooddelivery.demo.domaine.converter.ApplicationDeliveryConverter;
import com.blackhole.fooddelivery.demo.domaine.converter.ApplicationPlaceConverter;
import com.blackhole.fooddelivery.demo.domaine.vo.ApplicationDeliveryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.ApplicationPlaceVo;
import com.blackhole.fooddelivery.demo.model.ApplicationDelivery;
import com.blackhole.fooddelivery.demo.model.ApplicationPlace;
import com.blackhole.fooddelivery.demo.services.IApplicationDeliveryService;
import com.blackhole.fooddelivery.demo.services.IApplicationPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("applicationPlaceService")
@Transactional
public class ApplicationPlaceServiceImpl implements IApplicationPlaceService {
    @Autowired
    private ApplicationPlaceRepository applicationPlaceRepository;

    @Override
    public ApplicationPlaceVo getById(Long id) {
        boolean trouve = applicationPlaceRepository.existsById(id);
        if (!trouve)
            return null;
        return ApplicationPlaceConverter.toVo(applicationPlaceRepository.getById(id));
    }


    @Override
    public List<ApplicationPlaceVo> getAll() {
        List<ApplicationPlace> list = applicationPlaceRepository.findAll();
        return ApplicationPlaceConverter.toVoList(list);
    }

    @Override
    public List<ApplicationPlaceVo> getAllPagging(int page, int size) {
        PageRequest pr = PageRequest.of(page, size);
        List<ApplicationPlace> list = applicationPlaceRepository.findAll(pr).getContent();
        return ApplicationPlaceConverter.toVoList(list);
    }

    @Override
    public List<ApplicationPlaceVo> getAllByAll(String term) {
        return ApplicationPlaceConverter.toVoList(applicationPlaceRepository.findByNameContainsOrEmailContains(term, term));
    }

    @Override
    public List<ApplicationPlaceVo> getAllByAllPagging(String term, int page, int size) {
        PageRequest pr = PageRequest.of(page, size);
        List<ApplicationPlace> list = applicationPlaceRepository.findByNameContainsOrEmailContains(term, term, pr).getContent();
        return ApplicationPlaceConverter.toVoList(list);
    }

    @Override
    public void save(ApplicationPlaceVo applicationPlace) {
        applicationPlaceRepository.save(ApplicationPlaceConverter.toBo(applicationPlace));
    }

    @Override
    public void update(Long id, ApplicationPlaceVo applicationPlace) {
        applicationPlace.setId(id);
        applicationPlaceRepository.save(ApplicationPlaceConverter.toBo(applicationPlace));
    }

    @Override
    public void delete(Long id) {
        applicationPlaceRepository.deleteById(id);
    }

}
