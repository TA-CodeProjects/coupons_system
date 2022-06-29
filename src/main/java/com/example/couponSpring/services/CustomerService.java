package com.example.couponSpring.services;

import com.example.couponSpring.beans.Category;
import com.example.couponSpring.beans.Company;
import com.example.couponSpring.beans.Coupon;
import com.example.couponSpring.beans.Customer;
import com.example.couponSpring.exceptions.SystemException;

import java.util.List;

public interface CustomerService {
    void setCustomer(Customer customer);
    boolean login(String name, String password);
    void purchaseCoupon(Coupon coupon) throws SystemException;
    List<Coupon> getCustomerCoupons();
    List<Coupon> getCustomerCouponsByCategory(Category category);
    List<Coupon> getCustomerCouponsByMaxPrice(double price);
    Customer getCustomerDetails() throws SystemException;
    Customer getCustomerByEmail(String email) throws SystemException;


}
