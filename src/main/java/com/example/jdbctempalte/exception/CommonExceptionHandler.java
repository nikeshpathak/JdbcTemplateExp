package com.example.jdbctempalte.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by nikeshpathak on 22/07/17.
 */

@ControllerAdvice
public class CommonExceptionHandler {


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity commonException(Exception ex) {
        return new ResponseEntity(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataAccessException.class)
    @ResponseBody
    public ResponseEntity dataAccessException(DataAccessException ex) {
        return new ResponseEntity(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseBody
    public ResponseEntity emptyResultDataAccessException(EmptyResultDataAccessException ex) {
        return new ResponseEntity(ex.getMessage(),HttpStatus.NO_CONTENT);
    }

}
