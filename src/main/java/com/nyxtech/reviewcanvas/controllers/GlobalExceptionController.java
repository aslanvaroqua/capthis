package com.nyxtech.reviewcanvas.controllers;

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
    public ReviewCanvasApiError handleException(Exception ex) {
        log.warn("[GlobalExceptionController] handler caught ", ex);
        return new ReviewCanvasApiError(true, Throwables.getRootCause(ex).getMessage());
    }


    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ReviewCanvasApiError entityNotFoundException(EntityNotFoundException exception) {
        return new ReviewCanvasApiError(true, exception.getMessage());
    }
}
