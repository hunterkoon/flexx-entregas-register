package com.flexxEntregas.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
public class HandlerException extends RuntimeException {

    public String message;
    public String details;
    public Throwable cause;


    @Serial
    private static final long serialVersionUID = -1029470192740917240L;

    public HandlerException(String message, Throwable cause) {
        super(message, cause);
        if (cause.getMessage().contains("duplicate key")) {
            throw new HandlerException("Registro já foi inserido anteriormente", message, cause);
        } else {
            throw new HandlerException(message, cause);
        }
    }

    public HandlerException(String message, String details, Throwable cause) {
        this.message = message;
        this.details = details;
        this.cause = cause;
    }

    public HandlerException(String message){
        this.message = message;
    }

}
