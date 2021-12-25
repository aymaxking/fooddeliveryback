package com.blackhole.fooddelivery.demo.presentation.rest;

import com.blackhole.fooddelivery.demo.FoodDeliveryApplication;
import com.blackhole.fooddelivery.demo.domaine.vo.CategoryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.MenuVo;
import com.blackhole.fooddelivery.demo.domaine.vo.PlaceVo;
import com.blackhole.fooddelivery.demo.domaine.vo.TypeVo;
import com.blackhole.fooddelivery.demo.model.Category;
import com.blackhole.fooddelivery.demo.services.ICategoryService;
import com.blackhole.fooddelivery.demo.services.IPLaceService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/rest/categories")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    ICategoryService service;

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<CategoryVo> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/page/{p}/{s}",produces = {
            MediaType.APPLICATION_JSON_VALUE} )
    public List<CategoryVo> getAllPagging(@PathVariable(value="p") int p,@PathVariable(value="s") int s) {
        return service.getAllPagging(p,s);
    }

    @GetMapping(value = "/byTitle/{title}",produces = {
            MediaType.APPLICATION_JSON_VALUE} )
    public List<CategoryVo> getAllByTitle(@PathVariable(value="title") String title) {
        return service.getAllByTitlte(title);
    }

    @GetMapping(value = "/byTitle/{title}/{p}/{s}",produces = {
            MediaType.APPLICATION_JSON_VALUE} )
    public List<CategoryVo> getAllByTitlePagging(@PathVariable(value="title") String title,@PathVariable(value="p") int p,@PathVariable(value="s") int s) {
        return service.getAllByTitltePagging(title,p,s);
    }

    @GetMapping(value = "/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long VoId) {
        CategoryVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(VoFound, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody CategoryVo Vo) {
        service.save(Vo);
        return new ResponseEntity<>("created successfully",
                HttpStatus.CREATED);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable(name = "id") Long VoId,
                                            @RequestBody CategoryVo Vo) {
        CategoryVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        Vo.setId(VoId);
        service.save(Vo);
        return new ResponseEntity<>("updated successsfully",
                HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/addtype")
    public ResponseEntity<Object> addtype(@PathVariable(name = "id") Long VoId,
                                          @RequestBody TypeVo vo) {
        CategoryVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("category doen't exist", HttpStatus.OK);
        VoFound.addtype(vo);
        service.save(VoFound);
        return new ResponseEntity<>("category is updated successsfully",
                HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long VoId) {
        CategoryVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        service.delete(VoId);
        return new ResponseEntity<>("deleted successsfully",
                HttpStatus.OK);
    }
}
