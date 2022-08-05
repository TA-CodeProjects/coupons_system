package com.example.couponSpring.controller;

import com.example.couponSpring.beans.Coupon;
import com.example.couponSpring.repos.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/coupons")
@RequiredArgsConstructor
public class CouponController {
    private final CouponRepository couponRepository;

    @GetMapping
    public List<Coupon> getAllCoupons(){
        return couponRepository.findAll();
    }
}
