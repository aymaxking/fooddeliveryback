package com.blackhole.fooddelivery.demo.presentation.rest;
import com.blackhole.fooddelivery.demo.domaine.vo.TypeVo;
import com.blackhole.fooddelivery.demo.domaine.vo.UserVo;
import com.blackhole.fooddelivery.demo.services.ITypeService;
import com.blackhole.fooddelivery.demo.services.IUserService;
import com.blackhole.fooddelivery.demo.validator.UserValidator;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    IUserService service;
    @Autowired
    private AuthenticationManager authenticationManager;
    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<UserVo> getAll() {
        return service.getAllUsers();
    }


    @GetMapping(value = "/{username}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getByUsername(@PathVariable(value = "username") String username) {
        UserVo VoFound = service.getUserByUsername(username);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(VoFound, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
        UserVo VoFound = service.getById(id);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(VoFound, HttpStatus.OK);
    }

    @PutMapping(value = "/login", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@RequestBody UserVo vo ) {
        UserVo VoFound = service.login(vo);
        if (VoFound == null)
            return new ResponseEntity<>("{\"result\":\" notfound\"}",
                    HttpStatus.OK);
        return new ResponseEntity<>(VoFound, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody UserVo Vo) {
        service.save(Vo);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable(name = "id") Long VoId,
                                            @RequestBody UserVo Vo) {
        UserVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        Vo.setId(VoId);
        service.save(Vo);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteEmp(@PathVariable(name = "id") Long VoId) {
        UserVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        service.delete(VoId);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }

}
