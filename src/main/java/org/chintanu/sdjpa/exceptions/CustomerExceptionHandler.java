package org.chintanu.sdjpa.exceptions;

import org.chintanu.sdjpa.web.model.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class CustomerExceptionHandler {

    //@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorDto> customerNotFound(CustomerNotFoundException ex) {

        ErrorDto dto = new ErrorDto(ex.getMessage(), OffsetDateTime.now());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PageNotFoundException.class)
    public ResponseEntity<ErrorDto> pageNotFound(PageNotFoundException ex) {

        ErrorDto dto = new ErrorDto(ex.getMessage(), OffsetDateTime.now());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
