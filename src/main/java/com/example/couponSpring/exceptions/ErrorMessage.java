package com.example.couponSpring.exceptions;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    NAME_ALREADY_EXISTS("The name already exists"),
    EMAIL_ALREADY_EXISTS("The email already exists"),
    COMPANY_NOT_EXISTS("The company id not exists"),
    COMPANY_NOT_ALLOWED_UPDATE_NAME_OR_ID("It's not allowed to update company name or id"),
    CUSTOMER_NOT_EXISTS("The customer id not exists"),
    CUSTOMER_NOT_ALLOWED_UPDATE_ID("It not allowed to update customer id"),
    INVALID_EMAIL_OR_PASSWORD("Invalid email or password"),
    COUPON_ALREADY_EXISTS("The coupon title already exists"),
    COUPON_NOT_EXISTS("The coupon not exists"),
    COUPON_NOT_ALLOWED_UPDATE_COUPON_OR_COMPANY_CODE("It's not allowed to update coupon code or company code"),
    CUSTOMER_ALREADY_HAVE_COUPON("The customer already have this coupon"),
    NO_COUPON_LEFT("We are sorry all the coupon sold out"),
    COUPON_IS_DATE_EXPIRED("The coupon date is expired");


    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
