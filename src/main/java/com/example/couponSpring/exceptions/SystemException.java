package com.example.couponSpring.exceptions;

public class SystemException extends Exception{
    public SystemException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
