package com.evgueny.webshop.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String resourseNotFoundExceptionHandler(ResourseNotFoundException e){
        return e.getMessage();

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println(headers);
     //    return super.handleMethodArgumentNotValid(ex, headers, status, request);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("jjjjjj","hhkk");
        ResponseEntity<Object> responseEntity=new ResponseEntity<Object>("Ошибка запроса",httpHeaders,HttpStatus.BAD_REQUEST);
        return responseEntity;
    }


}
