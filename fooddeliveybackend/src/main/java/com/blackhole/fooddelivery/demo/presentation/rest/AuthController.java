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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserService userService;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody UserVo vo) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                vo.getUsername(), vo.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserVo vo) {
        if (userService.getUserByUsername(vo.getUsername()) == null) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        userService.save(vo);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }
}
