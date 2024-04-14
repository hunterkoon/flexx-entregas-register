package com.fleexEntregas.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Slf4j
public class ErrorDTO {

    private HttpStatus status;
    private String message;
    private String details;
    public ErrorDTO(HttpStatus status, String message, String details) {
        this.status = status;
        this.message = message;
        this.details = details;
    }
}
