package com.blackhole.fooddelivery.demo.presentation.rest;


import com.blackhole.fooddelivery.demo.dao.UserRepository;
import com.blackhole.fooddelivery.demo.domaine.vo.UserVo;
import com.blackhole.fooddelivery.demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/rest/auth")
public class AuthController {

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @PostMapping(value="/login")
//    public Object login(@RequestBody UserVo vo) {
//        final Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        vo.getUsername(),
//                        vo.getPassword()
//                )
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return authentication.getCredentials();
//    }

    @PostMapping(value="/login")
    public ResponseEntity<Object> login(@RequestBody UserVo vo) {
        UserVo VoFound = service.login(vo);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        return  new ResponseEntity<>(VoFound, HttpStatus.OK);
    }

    @PostMapping(value="/test")
    public String test(@RequestBody UserVo vo) {
        return "test";
    }

    }
