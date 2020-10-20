package com.mercadolibre.demo.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * METODO QUE PERMITE MANEJAR LA EXCEPTIONES DEL CONTROLLER RETORNA ESTADO 404
     * @param exception
     * @return ResponseEntity.class
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception exception) {
        log.error("Exception", exception);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("");
    }

}
