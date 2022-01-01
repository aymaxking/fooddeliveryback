package com.blackhole.fooddelivery.demo.presentation.rest;

import com.blackhole.fooddelivery.demo.domaine.vo.ClientVo;
import com.blackhole.fooddelivery.demo.domaine.vo.DeliveryVo;
import com.blackhole.fooddelivery.demo.services.IDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/deliveries")
@CrossOrigin("*")
public class DeliveryController {

    @Autowired
    IDeliveryService service;

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<DeliveryVo> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/page/{p}/{s}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<DeliveryVo> getAllPagging(@PathVariable(value = "p") int p, @PathVariable(value = "s") int s) {
        return service.getAllPagging(p, s);
    }

    @GetMapping(value = "/byAll/{term}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<DeliveryVo> getAllByTitle(@PathVariable(value = "term") String term) {
        return service.getAllByAll(term);
    }

    @GetMapping(value = "/byAll/{term}/{p}/{s}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<DeliveryVo> getAllByTitlePagging(@PathVariable(value = "term") String term, @PathVariable(value = "p") int p, @PathVariable(value = "s") int s) {
        return service.getAllByAllPagging(term, p, s);
    }

    @GetMapping(value = "/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long VoId) {
        DeliveryVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(VoFound, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody DeliveryVo Vo) {
        service.save(Vo);
        return new ResponseEntity<>("created successfully",
                HttpStatus.CREATED);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable(name = "id") Long VoId,
                                         @RequestBody DeliveryVo Vo) {
        DeliveryVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        Vo.setId(VoId);
        service.save(Vo);
        return new ResponseEntity<>("updated successsfully",
                HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long VoId) {
        DeliveryVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        service.delete(VoId);
        return new ResponseEntity<>("deleted successsfully",
                HttpStatus.OK);
    }
}
