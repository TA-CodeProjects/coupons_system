package com.example.couponSpring.controller;

import com.example.couponSpring.beans.*;
import com.example.couponSpring.exceptions.SystemException;
import com.example.couponSpring.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private CustomerService customerService;

//    @PostMapping("login")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void login(@RequestBody LoginParams loginParams) throws SystemException {
//        customerService = (CustomerService) loginManager.login(loginParams.getEmail(), loginParams.getPassword(), ClientType.Customer);
//    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void purchaseCoupon(@RequestBody Coupon coupon) throws SystemException {
        customerService.purchaseCoupon(coupon);
    }

    @GetMapping
    public List<Coupon> getAllCoupons(){
        return customerService.getCustomerCoupons();
    }

    @GetMapping("/category")
    public List<Coupon> getAllCouponByCategory(@RequestParam Category category){
        return customerService.getCustomerCouponsByCategory(category);
    }

    @GetMapping("/max_price")
    public List<Coupon> getAllCouponByMaxPrice(@RequestParam double maxPrice){
        return customerService.getCustomerCouponsByMaxPrice(maxPrice);
    }

    @GetMapping("/customer_details")
    public Customer getCustomerDetail() throws SystemException {
        return customerService.getCustomerDetails();
    }
}
