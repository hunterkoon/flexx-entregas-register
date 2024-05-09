package com.flexx.register.service.impl;

import com.flexx.register.business.RegisterUserValidation;
import com.flexx.register.model.UserDTO;
import com.flexx.register.repository.UserRegisterRepository;
import com.flexx.register.service.IUserRegisterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegisterServiceImpl implements IUserRegisterService {

    private final UserRegisterRepository repository;

    public UserRegisterServiceImpl(UserRegisterRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerUser(UserDTO userDTO) {
        RegisterUserValidation.validateData(repository, userDTO);
        repository.save(UserDTO.getEntity(userDTO));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return UserDTO.getListOfUserByEntity(repository.findAll());
    }
}
