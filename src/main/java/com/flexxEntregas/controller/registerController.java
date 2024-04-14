package com.flexxEntregas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Controller
@RequestMapping("api/v1/flexx")
public class registerController {

    @GetMapping("/up")
    ResponseEntity<String> helloWord(){
        return ResponseEntity.ok("This it working!");
    }

}
