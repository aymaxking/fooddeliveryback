package com.blackhole.fooddelivery.demo.presentation.rest;

import com.blackhole.fooddelivery.demo.domaine.vo.CategoryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.ClientVo;
import com.blackhole.fooddelivery.demo.domaine.vo.TypeVo;
import com.blackhole.fooddelivery.demo.services.ICategoryService;
import com.blackhole.fooddelivery.demo.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/clients")
@CrossOrigin("*")
public class ClientController {

    @Autowired
    IClientService service;

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<ClientVo> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/page/{p}/{s}",produces = {
            MediaType.APPLICATION_JSON_VALUE} )
    public List<ClientVo> getAllPagging(@PathVariable(value="p") int p,@PathVariable(value="s") int s) {
        return service.getAllPagging(p,s);
    }

    @GetMapping(value = "/byAll/{term}",produces = {
            MediaType.APPLICATION_JSON_VALUE} )
    public List<ClientVo> getAllByTitle(@PathVariable(value="term") String term) {
        return service.getAllByAll(term);
    }

    @GetMapping(value = "/byAll/{term}/{p}/{s}",produces = {
            MediaType.APPLICATION_JSON_VALUE} )
    public List<ClientVo> getAllByTitlePagging(@PathVariable(value="term") String term,@PathVariable(value="p") int p,@PathVariable(value="s") int s) {
        return service.getAllByAllPagging(term,p,s);
    }

    @GetMapping(value = "/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long VoId) {
        ClientVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(VoFound, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody ClientVo Vo) {
        service.save(Vo);
        return new ResponseEntity<>("created successfully",
                HttpStatus.CREATED);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable(name = "id") Long VoId,
                                            @RequestBody ClientVo Vo) {
        ClientVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        Vo.setId(VoId);
        service.save(Vo);
        return new ResponseEntity<>("updated successsfully",
                HttpStatus.OK);
    }




    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long VoId) {
        ClientVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        service.delete(VoId);
        return new ResponseEntity<>("deleted successsfully",
                HttpStatus.OK);
    }
}
