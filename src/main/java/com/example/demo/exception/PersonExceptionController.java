package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonExceptionController {
   @ExceptionHandler(value = InvalidPersonException.class)
   public ResponseEntity<Object> exception(InvalidPersonException exception) {
      return new ResponseEntity<>("Invalid Person " + exception.getMessage(), HttpStatus.BAD_REQUEST);
   }
}