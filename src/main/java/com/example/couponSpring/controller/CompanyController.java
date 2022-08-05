package com.example.couponSpring.controller;

import com.example.couponSpring.beans.*;
import com.example.couponSpring.exceptions.SystemException;
import com.example.couponSpring.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/company")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Coupon addCoupon(@RequestBody Coupon coupon) throws SystemException {
       return companyService.addCoupon(coupon);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoupon(@PathVariable int id, @RequestBody Coupon coupon) throws SystemException {
        companyService.updateCoupon(coupon);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoupon(@PathVariable int id) throws SystemException {
        companyService.deleteCoupon(id);
    }

    @GetMapping
    public List<Coupon> getAllCoupons() throws SystemException {
        return companyService.getCompanyCoupons();
    }

    @GetMapping("/{id}")
    public Coupon getOneCoupon(@PathVariable int id) throws SystemException {
        return companyService.getOneCoupon(id);
    }

    @GetMapping("/category")
    private List<Coupon> getCouponsByCategory(@RequestParam Category category) throws SystemException {
        return companyService.getCompanyCouponsByCategory(category);
    }

    @GetMapping("/max_price")
    public List<Coupon> getCouponsByMaxPrice(@RequestParam double maxPrice) throws SystemException {
        return companyService.getCompanyCouponsByMaxPrice(maxPrice);
    }

    @GetMapping("/company_details")
    public Company getCompanyDetails() throws SystemException {
        return companyService.getCompanyDetails();
    }



}
