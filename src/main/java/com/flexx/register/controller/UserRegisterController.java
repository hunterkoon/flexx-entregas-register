package com.flexx.register.controller;

import com.flexx.register.model.UserDTO;
import com.flexx.register.service.IUserRegisterService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@Controller
@Slf4j
@RequestMapping("api/v1/flexx/user")
public class UserRegisterController {

    private final IUserRegisterService service;

    public UserRegisterController(IUserRegisterService service) {
        this.service = service;
    }

    @PostMapping("/register")
    ResponseEntity<String> register(@Valid @RequestBody UserDTO userDTO) {
        log.info("register user was called");
        service.registerUser(userDTO);
        return ResponseEntity.ok("created!");
    }

    @GetMapping
    ResponseEntity<List<UserDTO>> getAllUsers() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        return ResponseEntity.ok(service.getAllUsers());
    }

}
