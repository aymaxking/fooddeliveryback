package com.blackhole.fooddelivery.demo.presentation.rest;

import com.blackhole.fooddelivery.demo.dao.CategoryRepository;
import com.blackhole.fooddelivery.demo.dao.PlaceRepository;
import com.blackhole.fooddelivery.demo.domaine.vo.MenuVo;
import com.blackhole.fooddelivery.demo.domaine.vo.PlaceVo;
import com.blackhole.fooddelivery.demo.domaine.vo.SubMenuVo;
import com.blackhole.fooddelivery.demo.model.Category;
import com.blackhole.fooddelivery.demo.model.Place;
import com.blackhole.fooddelivery.demo.services.IPLaceService;
import com.blackhole.fooddelivery.demo.services.implementations.PlaceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "rest/places")
@CrossOrigin("*")
public class PlaceController {

    @Autowired
    IPLaceService service;

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<PlaceVo> getAll() {
        return service.getAll();
    }


    @GetMapping(value = "/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long VoId) {
        PlaceVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("place doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(VoFound, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createEmp(@Validated @RequestBody PlaceVo Vo) {
        service.save(Vo);
        return new ResponseEntity<>("place is created successfully",
                HttpStatus.CREATED);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateEmp(@PathVariable(name = "id") Long VoId,
                                            @RequestBody PlaceVo Vo) {
        PlaceVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("place doen't exist", HttpStatus.OK);
        Vo.setId(VoId);
        service.save(Vo);
        return new ResponseEntity<>("place is updated successsfully",
                HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteEmp(@PathVariable(name = "id") Long VoId) {
        PlaceVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("place doen't exist", HttpStatus.OK);
        service.delete(VoId);
        return new ResponseEntity<>("place is deleted successsfully",
                HttpStatus.OK);
    }


    @PutMapping(value = "/{id}/addmenu")
    public ResponseEntity<Object> addmenu(@PathVariable(name = "id") Long VoId,
                                            @RequestBody MenuVo vo) {
        PlaceVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("place doen't exist", HttpStatus.OK);
        VoFound.addmenu(vo);
        service.save(VoFound);
        return new ResponseEntity<>("place is updated successsfully",
                HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/menus/{id2}/addsubmenu")
    public ResponseEntity<Object> addsubmenu(@PathVariable(name = "id") Long VoId,
                                             @PathVariable(name = "id2") Long VoId2,
                                          @RequestBody SubMenuVo vo) {
        PlaceVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("place doen't exist", HttpStatus.OK);
        MenuVo VoFound2 = VoFound.findmenubyid(VoId2);
        if (VoFound2 == null)
            return new ResponseEntity<>("menu doen't exist", HttpStatus.OK);
        VoFound2.addsubmenu(vo);
        service.save(VoFound);
        return new ResponseEntity<>("place is updated successsfully",
                HttpStatus.OK);
    }



}