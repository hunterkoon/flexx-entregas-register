package com.flexx.register.controller;

import com.flexx.register.model.UserDTO;
import com.flexx.register.service.IUserRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("api/v1/flexx/user/")
public class UserRegisterController {

    private final IUserRegisterService service;

    public UserRegisterController(IUserRegisterService service) {
        this.service = service;
    }

    @PostMapping("/register")
    ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        service.registerUser(userDTO);
        return ResponseEntity.ok("created!");
    }

}
