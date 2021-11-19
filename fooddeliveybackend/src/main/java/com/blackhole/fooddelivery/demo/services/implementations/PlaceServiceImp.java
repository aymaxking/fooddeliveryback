package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.dao.PlaceRepository;
import com.blackhole.fooddelivery.demo.domaine.converter.PlaceConverter;
import com.blackhole.fooddelivery.demo.domaine.vo.PlaceVo;
import com.blackhole.fooddelivery.demo.model.Place;
import com.blackhole.fooddelivery.demo.services.IPLaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("placeService")
@Transactional
public class PlaceServiceImp implements IPLaceService {
    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public PlaceVo getById(Long id) {
        boolean trouve = placeRepository.existsById(id);
        if (!trouve)
            return null;
        return PlaceConverter.toVo(placeRepository.getOne(id));
    }

    @Override
    public List<PlaceVo> getAll() {
        List<Place> list = placeRepository.findAll();
        return PlaceConverter.toVoList(list);
    }

    @Override
    public void save(PlaceVo place) {
        placeRepository.save(PlaceConverter.toBo(place));
    }

    @Override
    public void update(Long id, PlaceVo place) {
        place.setId(id);
        placeRepository.save(PlaceConverter.toBo(place));
    }

    @Override
    public void delete(Long id) {
        placeRepository.deleteById(id);
    }

    @Override
    public List<PlaceVo> findByTitle(String title) {
        List<Place> list = placeRepository.findByTitle(title);
        return PlaceConverter.toVoList(list);
    }

    @Override
    public List<PlaceVo> findAll(int pageId, int size) {
        Page<Place> result = placeRepository.findAll(PageRequest.of(pageId, size,
                Sort.Direction.ASC, "name"));
        return PlaceConverter.toVoList(result.getContent());     }

    @Override
    public List<PlaceVo> sortBy(String fieldName) {
        return PlaceConverter.toVoList(placeRepository.findAll(Sort.by(fieldName)));
    }
}
