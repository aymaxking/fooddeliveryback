package com.blackhole.fooddelivery.demo.presentation.rest;

import com.blackhole.fooddelivery.demo.EmailContent;
import com.blackhole.fooddelivery.demo.domaine.vo.ApplicationDeliveryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.ApplicationPlaceVo;
import com.blackhole.fooddelivery.demo.domaine.vo.UserVo;
import com.blackhole.fooddelivery.demo.services.IApplicationDeliveryService;
import com.blackhole.fooddelivery.demo.services.IApplicationPlaceService;
import com.blackhole.fooddelivery.demo.services.IMailService;
import com.blackhole.fooddelivery.demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/rest/applicationsPlace")
@CrossOrigin("*")
public class ApplicationPlaceController {

    @Autowired
    IApplicationPlaceService service;

    @Autowired
    IUserService serviceUser;
    @Autowired
    IMailService mailService;

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<ApplicationPlaceVo> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/page/{p}/{s}",produces = {
            MediaType.APPLICATION_JSON_VALUE} )
    public List<ApplicationPlaceVo> getAllPagging(@PathVariable(value="p") int p,@PathVariable(value="s") int s) {
        return service.getAllPagging(p,s);
    }

    @GetMapping(value = "/byAll/{term}",produces = {
            MediaType.APPLICATION_JSON_VALUE} )
    public List<ApplicationPlaceVo> getAllByTitle(@PathVariable(value="term") String term) {
        return service.getAllByAll(term);
    }

    @GetMapping(value = "/byAll/{term}/{p}/{s}",produces = {
            MediaType.APPLICATION_JSON_VALUE} )
    public List<ApplicationPlaceVo> getAllByTitlePagging(@PathVariable(value="term") String term,@PathVariable(value="p") int p,@PathVariable(value="s") int s) {
        return service.getAllByAllPagging(term,p,s);
    }

    @GetMapping(value = "/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long VoId) {
        ApplicationPlaceVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(VoFound, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody ApplicationPlaceVo Vo) {
        service.save(Vo);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping("/received")
    public ResponseEntity<Object> applicationtsent(@RequestBody ApplicationPlaceVo Vo) throws MessagingException {
        EmailContent.name=Vo.getName();
          mailService.sendEmail(Vo.getEmail(),"Confirmation", EmailContent.emailVerification);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);

    }

    @ResponseBody
    @PutMapping("/accepted")
    public ResponseEntity<Object> accepted(@RequestBody ApplicationPlaceVo Vo) {
        EmailContent.name=Vo.getName();
        mailService.sendEmail(Vo.getEmail(),"Congratulations", EmailContent.emailAccepted);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping("/refused")
    public ResponseEntity<Object> refuse(@RequestBody ApplicationPlaceVo Vo) {
        EmailContent.name=Vo.getName();
        mailService.sendEmail(Vo.getEmail(),"Congratulations", EmailContent.emailRefused);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable(name = "id") Long VoId,
                                            @RequestBody ApplicationPlaceVo Vo) {
        ApplicationPlaceVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        Vo.setId(VoId);
        service.save(Vo);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long VoId) {
        ApplicationPlaceVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        service.delete(VoId);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }
}
