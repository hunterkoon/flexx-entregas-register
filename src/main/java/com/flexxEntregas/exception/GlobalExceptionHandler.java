package com.flexxEntregas.exception;


import com.flexxEntregas.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = HandlerException.class)
    public ResponseEntity<ErrorDTO> handleException(HandlerException ex) {
        return new ResponseEntity<>(
                new ErrorDTO(HttpStatus.BAD_REQUEST, ex.getMessage(), ex.getDetails()), HttpStatus.BAD_REQUEST);
    }
}
