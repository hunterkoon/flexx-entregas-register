package com.flexx.register.service;

import com.flexx.register.model.UserDTO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface IUserRegisterService {
    void registerUser(UserDTO userDTO);
    List<UserDTO> getAllUsers() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException;
}
