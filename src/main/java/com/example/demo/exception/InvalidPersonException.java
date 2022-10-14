package com.example.demo.exception;

public class InvalidPersonException extends RuntimeException {
   private static final long serialVersionUID = 1L;

   public InvalidPersonException(String s) {
      super(s);
   }
}