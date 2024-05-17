package dev.bhumika.productservice.advice;

import dev.bhumika.productservice.dtos.ErrorDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


//This is global.This will be called when any exception is thrown by an controller
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNullPointerException(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Something went wrong. Please try again");

        return new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(404));

    }
}
