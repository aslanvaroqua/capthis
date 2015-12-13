package com.nyxtech.capthis.controllers;

import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionController {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionController.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public CapThisApiError handleException(Exception ex) {
        log.warn("[GlobalExceptionController] handler caught ", ex);
        return new CapThisApiError(true, Throwables.getRootCause(ex).getMessage());
    }


    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public CapThisApiError entityNotFoundException(EntityNotFoundException exception) {
        return new CapThisApiError(true, exception.getMessage());
    }
}
