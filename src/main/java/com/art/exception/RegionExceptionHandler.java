package com.art.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RegionExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegionExceptionHandler.class);

    @ExceptionHandler(RegionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String regionNotFoundExceptionHandler(RegionNotFoundException e) {
        LOGGER.error(e.getMessage());
        e.printStackTrace();
        return e.getMessage();
    }
}
