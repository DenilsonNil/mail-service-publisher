package br.com.kualit.mailservice.publisher.controllers;


import br.com.kualit.mailservice.publisher.dto.EmailDTO;
import br.com.kualit.mailservice.publisher.services.IPublisherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/v1/notification")
public class EmailController {
    @Autowired
    private IPublisherService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody @Valid EmailDTO dto) {

        String response = emailService.sendEmail(dto);

        return new ResponseEntity<>(response, OK);
    }
}
