package com.blackhole.fooddelivery.demo.presentation.rest;

import com.blackhole.fooddelivery.demo.domaine.vo.*;
import com.blackhole.fooddelivery.demo.services.IPLaceService;
import com.blackhole.fooddelivery.demo.utils.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "rest/places")
@CrossOrigin("*")
public class PlaceController {

    @Autowired
    IPLaceService service;

    @Autowired
    public JavaMailSender emailSender;

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<PlaceVo> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/page/{p}/{s}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<PlaceVo> getAllPagging(@PathVariable(value = "p") int p, @PathVariable(value = "s") int s) {
        return service.getAllPagging(p, s);
    }

    @GetMapping(value = "/byAll/{term}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<PlaceVo> getAllByTitle(@PathVariable(value = "term") String term) {
        return service.getAllByAll(term);
    }

    @GetMapping(value = "/byAll/{term}/{p}/{s}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<PlaceVo> getAllByTitlePagging(@PathVariable(value = "term") String term, @PathVariable(value = "p") int p, @PathVariable(value = "s") int s) {
        return service.getAllByAllPagging(term, p, s);
    }


    @GetMapping(value = "/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long VoId) {
        PlaceVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("place doen't exist", HttpStatus.OK);
        VoFound.setImg(ImageUtility.decompressImage(VoFound.getImg()));
        if( VoFound.getMenus()!=null)
            for(MenuVo m : VoFound.getMenus())
            if(m.getSubMenus()!=null)
            for(SubMenuVo s : m.getSubMenus())
                s.setImg(ImageUtility.decompressImage(s.getImg()));
        return new ResponseEntity<>(VoFound, HttpStatus.OK);
    }

    @PostMapping(value = "l")
    public ResponseEntity<Object> createEmp(@Validated @RequestBody PlaceVo Vo) {
        service.save(Vo);
        return new ResponseEntity<>("place is created successfully",
                HttpStatus.CREATED);
    }


    @PostMapping
    public ResponseEntity<Object> createPlace(@RequestBody ApplicationPlaceVo Vo) {
        PlaceVo vo = new PlaceVo(Vo);
        vo.setImg(vo.getImg());
        service.save(vo);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(Vo.getEmail());
        message.setFrom("FoodInNoReply@gmail.com");
        message.setSubject("Login Data");
        message.setText("Email : " + vo.getUsername() + "    Password:" + vo.getPassword());
        this.emailSender.send(message);
        return new ResponseEntity<>("place is created successfully",
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateEmp(@PathVariable(name = "id") Long VoId,
                                            @RequestBody PlaceVo Vo) {
        PlaceVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("place doen't exist", HttpStatus.OK);
        Vo.setId(VoId);
        service.save(Vo);
        return new ResponseEntity<>("place is updated successsfully",
                HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteEmp(@PathVariable(name = "id") Long VoId) {
        PlaceVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("place doen't exist", HttpStatus.OK);
        service.delete(VoId);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }


    @PutMapping(value = "/{id}/addmenu")
    public ResponseEntity<Object> addmenu(@PathVariable(name = "id") Long VoId,
                                          @RequestBody MenuVo vo) {
        PlaceVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("place doen't exist", HttpStatus.OK);
        VoFound.addmenu(vo);
        service.save(VoFound);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }


    @PutMapping(value = "/{id}/menus/{id2}/addsubmenu")
    public ResponseEntity<Object> addsubmenu(@PathVariable(name = "id") Long VoId,
                                             @PathVariable(name = "id2") Long VoId2,
                                             @RequestBody SubMenuVo vo) throws UnsupportedEncodingException {
        PlaceVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("place doesn't exist", HttpStatus.OK);
        MenuVo VoFound2 = VoFound.findmenubyid(VoId2);
        if (VoFound2 == null)
            return new ResponseEntity<>("menu doesn't exist", HttpStatus.OK);
        vo.setImg(ImageUtility.compressImage(vo.getImg()));
        VoFound2.addsubmenu(vo);
        service.save(VoFound);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }



}
