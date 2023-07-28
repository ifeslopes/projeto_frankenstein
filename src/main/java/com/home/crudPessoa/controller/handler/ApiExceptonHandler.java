package com.home.crudPessoa.controller.handler;

import com.home.crudPessoa.exception.DadosInvalidosEception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptonHandler {
    private static final String BAD_RESQUEST = "Bad Resquest";
    private static final LocalDateTime TIMETAMP = LocalDateTime.now();

    @ExceptionHandler(DadosInvalidosEception.class)
    public ResponseEntity<ErrorResponse> handlerDadosInvalidosEception(DadosInvalidosEception ex) {
        ErrorResponse response = ErrorResponse
                .builder()
                .title(BAD_RESQUEST)
                .codStatus(HttpStatus.BAD_REQUEST.value())
                .timestamp(TIMETAMP)
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

    }
}
