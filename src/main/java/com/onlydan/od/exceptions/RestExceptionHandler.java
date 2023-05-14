package com.onlydan.od.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler({ ResponseException.class })
    public ResponseEntity<Object> handleAll(final ResponseException e, final WebRequest request) {
        return new ResponseEntity<>(e.getResponseBody(), new HttpHeaders(), e.getResponseBody().getHttpStatus());
    }
}
