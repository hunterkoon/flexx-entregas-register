package com.flexx.register.Error;

import com.flexx.register.model.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
@Slf4j
public class HandlerExceptions {
    @ExceptionHandler({ApplicationBusinessError.class})
    ResponseEntity<ErrorDTO> throwErrorApp(ApplicationBusinessError ex) {
        log.error(ex.getMessage(), ex);
        ErrorDTO err = new ErrorDTO(ex.getHttpStatus(), ex.getMessage());
        return new ResponseEntity<>(err, ex.getHttpStatus());
    }
    @ExceptionHandler({MethodArgumentNotValidException.class})
    ResponseEntity<ErrorDTO> validFieldException(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage(), ex);
        ErrorDTO err = new ErrorDTO(HttpStatus.valueOf(ex.getStatusCode().value()),
                Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage());
        return new ResponseEntity<>(err, HttpStatus.valueOf(ex.getStatusCode().value()));
    }

}
