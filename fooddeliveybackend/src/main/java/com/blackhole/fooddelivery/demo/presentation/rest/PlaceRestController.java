package com.blackhole.fooddelivery.demo.presentation.rest;

import com.blackhole.fooddelivery.demo.domaine.vo.CategoryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.PlaceVo;
import com.blackhole.fooddelivery.demo.services.ICategoryService;
import com.blackhole.fooddelivery.demo.services.IPLaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaceRestController
{
    @Autowired
    private IPLaceService service;

    @GetMapping(value = "/rest/place", produces = { MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE })
    public List<PlaceVo> getAll() {
        return service.getAllPlaces();
    }

    @GetMapping(value = "/rest/place/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long VoId)
    {
        PlaceVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("Place doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(VoFound, HttpStatus.OK);
    }

    @PostMapping(value = "/rest/place")
    public ResponseEntity<Object> create(@Validated  @RequestBody PlaceVo Vo) {
        service.save(Vo);
        return new ResponseEntity<>("Place is created successfully",
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/rest/place/{id}")
    public ResponseEntity<Object> update(@PathVariable(name = "id") Long VoId,
                                            @RequestBody PlaceVo Vo) {
        PlaceVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("Place doen't exist", HttpStatus.OK);
        Vo.setId(VoId);
        service.save(Vo);
        return new ResponseEntity<>("Place is updated successsfully",
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/rest/place/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long VoId) {
        PlaceVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("Place doen't exist", HttpStatus.OK);
        service.delete(VoId);
        return new ResponseEntity<>("Place is deleted successsfully",
                HttpStatus.OK);
    }


}
