package com.example.couponSpring.services;

import com.example.couponSpring.beans.Category;
import com.example.couponSpring.beans.Company;
import com.example.couponSpring.beans.Coupon;
import com.example.couponSpring.exceptions.SystemException;

import java.util.List;
public interface CompanyService {
    void setCompany(Company company);

    boolean login(String email, String password);

    void addCoupon(Coupon coupon) throws SystemException;

    void updateCoupon(Coupon coupon) throws SystemException;

    void deleteCoupon(int couponId) throws SystemException;

    List<Coupon> getCompanyCoupons() throws SystemException;

    List<Coupon> getCompanyCouponsByCategory(Category category) throws SystemException;

    List<Coupon> getCompanyCouponsByMaxPrice(double maxPrice) throws SystemException;

    Company getCompanyDetails() throws SystemException;

    Coupon getOneCoupon(int couponId) throws SystemException;

    Company getCompanyByEmail(String email) throws SystemException;

}
