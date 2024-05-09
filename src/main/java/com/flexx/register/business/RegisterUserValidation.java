package com.flexx.register.business;

import com.flexx.register.Error.ApplicationBusinessError;
import com.flexx.register.Error.ErrorsMessage;
import com.flexx.register.model.UserDTO;
import com.flexx.register.repository.UserRegisterRepository;
import org.springframework.http.HttpStatus;

public class RegisterUserValidation {

    //TODO ADICIONAR TRATAMENTO DE ERROS PARA REQUISIÇÕES DE CADASTROS DE USUÁRIO
    public static void validateData(UserRegisterRepository repository, UserDTO input) {
        if (repository.existsByDocument(input.getDocumentNumber())) {
            throw new ApplicationBusinessError(ErrorsMessage.Messages.USER_ALREADY_CREATED, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
