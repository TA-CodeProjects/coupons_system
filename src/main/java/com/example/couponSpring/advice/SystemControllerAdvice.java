package com.example.couponSpring.advice;

import com.example.couponSpring.exceptions.SystemException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SystemControllerAdvice {

    @ExceptionHandler(value = SystemException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrDetail handleError(Exception e){
        return new ErrDetail("System Error", e.getMessage());
    }
}
