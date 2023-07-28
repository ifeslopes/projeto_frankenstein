package com.home.crudPessoa.controller.handler;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
public class ErrorResponse {
    private String title;
    private LocalDateTime timestamp;
    private  int codStatus;
    private String message;
}
