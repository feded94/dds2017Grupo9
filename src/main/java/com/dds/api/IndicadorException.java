package com.dds.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IndicadorException extends RuntimeException {

    public IndicadorException() {
        super("No se pudo generar el indicador, revisar la expresión ingresada.");
    }
}
