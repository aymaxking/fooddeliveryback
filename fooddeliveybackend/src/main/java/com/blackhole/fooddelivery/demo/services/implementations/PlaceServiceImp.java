package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.domaine.vo.PlaceVo;
import com.blackhole.fooddelivery.demo.services.IPLaceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
@Transactional
public class PlaceServiceImp implements IPLaceService {
    @Override
    public PlaceVo getById(Long id) {
        return null;
    }

    @Override
    public List<PlaceVo> getAllPlaces() {
        return null;
    }

    @Override
    public void save(PlaceVo place) {

    }

    @Override
    public void update(Long id, PlaceVo place) {

    }

    @Override
    public void delete(Long id) {

    }
}
