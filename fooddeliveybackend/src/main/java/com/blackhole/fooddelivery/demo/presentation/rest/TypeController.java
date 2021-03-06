package com.blackhole.fooddelivery.demo.presentation.rest;

import com.blackhole.fooddelivery.demo.domaine.vo.CategoryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.TypeVo;
import com.blackhole.fooddelivery.demo.services.ICategoryService;
import com.blackhole.fooddelivery.demo.services.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/types")
@CrossOrigin("*")
public class TypeController {

    @Autowired
    ITypeService service;

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<TypeVo> getAll() {
        return service.getAll();
    }


    @GetMapping(value = "/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long VoId) {
        TypeVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(VoFound, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createEmp(@Validated @RequestBody TypeVo Vo) {
        service.save(Vo);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateEmp(@PathVariable(name = "id") Long VoId,
                                            @RequestBody TypeVo Vo) {
        TypeVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        Vo.setId(VoId);
        service.save(Vo);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteEmp(@PathVariable(name = "id") Long VoId) {
        TypeVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        service.delete(VoId);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }
}
