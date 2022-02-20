package com.blackhole.fooddelivery.demo.presentation.rest;

import com.blackhole.fooddelivery.demo.domaine.vo.CommandeVo;
import com.blackhole.fooddelivery.demo.services.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/orders")
@CrossOrigin("*")
public class CommandeController {

    @Autowired
    ICommandeService service;

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<CommandeVo> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/page/{p}/{s}",produces = {
            MediaType.APPLICATION_JSON_VALUE} )
    public List<CommandeVo> getAllPagging(@PathVariable(value="p") int p, @PathVariable(value="s") int s) {
        return service.getAllPagging(p,s);
    }



    @GetMapping(value = "/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long VoId) {
        CommandeVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(VoFound, HttpStatus.OK);
    }

    @GetMapping(value = "/byClient/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<CommandeVo> getByClient(@PathVariable(value = "id") Long VoId) {
        return service.getByClient(VoId);
    }

    @GetMapping(value = "/byDelivery/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<CommandeVo> getByDelivery(@PathVariable(value = "id") Long VoId) {
        return service.getByDelivery(VoId);
    }

    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody CommandeVo Vo) {
        service.save(Vo);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable(name = "id") Long VoId,
                                            @RequestBody CommandeVo Vo) {
        CommandeVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        Vo.setId(VoId);
        service.save(Vo);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long VoId) {
        CommandeVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        service.delete(VoId);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }
}
