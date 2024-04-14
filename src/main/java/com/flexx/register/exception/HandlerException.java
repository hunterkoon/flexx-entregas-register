package com.flexx.register.exception;

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
            //TODO IMPLEMENTAR LOGICA DE EXCEÇÃO
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
