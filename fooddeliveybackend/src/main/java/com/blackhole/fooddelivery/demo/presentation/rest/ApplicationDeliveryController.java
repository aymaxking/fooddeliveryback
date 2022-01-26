package com.blackhole.fooddelivery.demo.presentation.rest;

import com.blackhole.fooddelivery.demo.domaine.vo.ApplicationDeliveryVo;
import com.blackhole.fooddelivery.demo.domaine.vo.ClientVo;
import com.blackhole.fooddelivery.demo.services.IApplicationDeliveryService;
import com.blackhole.fooddelivery.demo.services.IClientService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pdf.PDFExporter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest/applicationsDelivery")
@CrossOrigin("*")
public class ApplicationDeliveryController {

    @Autowired
    IApplicationDeliveryService service;

    @Autowired
    public JavaMailSender emailSender;

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<ApplicationDeliveryVo> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/page/{p}/{s}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<ApplicationDeliveryVo> getAllPagging(@PathVariable(value = "p") int p, @PathVariable(value = "s") int s) {
        return service.getAllPagging(p, s);
    }

    @GetMapping(value = "/byAll/{term}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<ApplicationDeliveryVo> getAllByTitle(@PathVariable(value = "term") String term) {
        return service.getAllByAll(term);
    }

    @GetMapping(value = "/byAll/{term}/{p}/{s}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public List<ApplicationDeliveryVo> getAllByTitlePagging(@PathVariable(value = "term") String term, @PathVariable(value = "p") int p, @PathVariable(value = "s") int s) {
        return service.getAllByAllPagging(term, p, s);
    }

    @GetMapping(value = "/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long VoId) {
        ApplicationDeliveryVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(VoFound, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody ApplicationDeliveryVo Vo) {
        service.save(Vo);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable(name = "id") Long VoId,
                                         @RequestBody ApplicationDeliveryVo Vo) {
        ApplicationDeliveryVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        Vo.setId(VoId);
        service.save(Vo);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping("/accepted")
    public ResponseEntity<Object> accepted(@RequestBody ApplicationDeliveryVo Vo) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(Vo.getEmail());
        message.setFrom("aymanehamidat@gmail.com");
        message.setSubject("Reponse");
        message.setText("You Are Accepted");
        this.emailSender.send(message);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping("/validated")
    public ResponseEntity<Object> validated(@RequestBody ApplicationDeliveryVo Vo) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(Vo.getEmail());
        message.setFrom("aymanehamidat@gmail.com");
        message.setSubject("Reponse");
        message.setText("You Are Now A delivery ( Email :" + Vo.getEmail() + ",Password : Password");
        this.emailSender.send(message);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }

    @GetMapping("/generateContract")
    public void exportToPDF(HttpServletResponse response, @RequestBody ApplicationDeliveryVo Vo) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=application_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        PDFExporter exporter = new PDFExporter(Vo);
        exporter.export(response);
    }

    @ResponseBody
    @PutMapping("/refused")
    public ResponseEntity<Object> refuse(@RequestBody ApplicationDeliveryVo Vo) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(Vo.getEmail());
        message.setFrom("aymanehamidat@gmail.com");
        message.setSubject("Reponse");
        message.setText("You Are Refused");
        this.emailSender.send(message);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long VoId) {
        ApplicationDeliveryVo VoFound = service.getById(VoId);
        if (VoFound == null)
            return new ResponseEntity<>("doen't exist", HttpStatus.OK);
        service.delete(VoId);
        return new ResponseEntity<>("{\"result\":\" successsfully\"}",
                HttpStatus.OK);
    }
}
