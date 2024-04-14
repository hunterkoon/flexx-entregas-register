package com.flexx.register.exception;


import com.flexx.register.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception ex) {

        if (ex != null) {
            if (ex instanceof RuntimeException) {
                return new ResponseEntity<>(
                        new ErrorDTO(HttpStatus.BAD_REQUEST, ex.getMessage()), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(
                    new ErrorDTO(HttpStatus.BAD_REQUEST, ex.getMessage(), ex.getCause().getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(
                new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", ""), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
