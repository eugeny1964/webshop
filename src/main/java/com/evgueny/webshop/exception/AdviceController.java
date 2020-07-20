package com.evgueny.webshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String resourseNotFoundExceptionHandler(ResourseNotFoundException e){
        return e.getMessage();

    }
    @ExceptionHandler(NullPointerException.class)
    public String resourseNullPointerException(NullPointerException e){
        return e.getMessage();
    }

    @ExceptionHandler(ConstraintViolationExeption.class)
    public String resourseConstraintViolationExeption(ConstraintViolationExeption e){
        return e.getMessage();
    }
    
/*@ExceptionHandler(value = {IllegalArgumentException.class,IllegalStateException.class})
    public ResponseEntity<Object> IllegalExceptionHandler(RuntimeException exception){

}*/
    



}
