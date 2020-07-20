package com.evgueny.webshop.exception;

public class ResourseNotFoundException extends RuntimeException {
    public ResourseNotFoundException(String name, Long id){
        super(name+ " c id = "+ id+" не найден");
    }
}
