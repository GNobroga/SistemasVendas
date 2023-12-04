package com.supermecado.SistemasVendas.helpers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends RuntimeException {

    private int status = 500;

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, int status) {
        super(message);
        this.status = status;
    }

}
