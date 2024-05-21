package com.example.SpringRestMySQL.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyHandler {

        @ExceptionHandler
        public ResponseEntity<ErrolResponse> batLoi(Exception ex){
            ErrolResponse ers=new ErrolResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
            return ResponseEntity.badRequest().body(ers);
        }


}
