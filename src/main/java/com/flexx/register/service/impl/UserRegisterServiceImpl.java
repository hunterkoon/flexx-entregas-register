package com.flexx.register.service.impl;

import com.flexx.register.model.UserDTO;
import com.flexx.register.repository.UserRegisterRepository;
import com.flexx.register.service.IUserRegisterService;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterServiceImpl implements IUserRegisterService {

    private final UserRegisterRepository repository;

    public UserRegisterServiceImpl(UserRegisterRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerUser(UserDTO userDTO) {
        repository.findByDocument(userDTO.getDocumentNumber()).ifPresent(
                userEntity -> {
                    throw new RuntimeException("Usuário ja foi registrado");
                });
        repository.save(UserDTO.getEntity(userDTO));
    }
}
