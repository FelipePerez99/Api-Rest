package com.alura.api.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TrataDeErrores {
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }
}