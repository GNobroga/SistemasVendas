package com.supermecado.SistemasVendas.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.supermecado.SistemasVendas.helpers.AppException;
import com.supermecado.SistemasVendas.helpers.CustomError;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public CustomError mainExceptionHandler(Exception ex) {
        var error = new CustomError();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        return error;
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<CustomError> mainExceptionHandler(AppException ex) {
        var error = new CustomError();
        error.setStatusCode(ex.getStatus());
        error.setMessage(ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(error);
    }

}
