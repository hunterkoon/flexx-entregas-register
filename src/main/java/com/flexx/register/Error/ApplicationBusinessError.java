package com.flexx.register.Error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationBusinessError extends Error {

    private final HttpStatus httpStatus;
    private final String message;

    public ApplicationBusinessError(String message, HttpStatus status) {
        super();
        this.httpStatus = status;
        this.message = message;
    }

}
