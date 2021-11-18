package com.blackhole.fooddelivery.demo.presentation.rest;

import com.blackhole.fooddelivery.demo.domaine.vo.CategoryVo;
import com.blackhole.fooddelivery.demo.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CategoryRestController
{
    @Autowired
    private ICategoryService service;

    @GetMapping(value = "/rest/category", produces = { MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE })
    public List<CategoryVo> getAll() {
        return service.getAllCategorys();
    }

    @GetMapping(value = "/rest/category/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long VoId)
    {
        CategoryVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("category doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(VoFound, HttpStatus.OK);
    }

    @PostMapping(value = "/rest/category")
    public ResponseEntity<Object> create(@Validated  @RequestBody CategoryVo Vo) {
        service.save(Vo);
        return new ResponseEntity<>("category is created successfully",
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/rest/category/{id}")
    public ResponseEntity<Object> update(@PathVariable(name = "id") Long VoId,
                                            @RequestBody CategoryVo Vo) {
        CategoryVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("Category doen't exist", HttpStatus.OK);
        Vo.setId(VoId);
        service.save(Vo);
        return new ResponseEntity<>("Category is updated successsfully",
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/rest/category/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long VoId) {
        CategoryVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("Category doen't exist", HttpStatus.OK);
        service.delete(VoId);
        return new ResponseEntity<>("Category is deleted successsfully",
                HttpStatus.OK);
    }


}
