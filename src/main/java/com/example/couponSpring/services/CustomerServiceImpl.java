package com.example.couponSpring.services;

import com.example.couponSpring.beans.Category;
import com.example.couponSpring.beans.Coupon;
import com.example.couponSpring.beans.Customer;
import com.example.couponSpring.exceptions.ErrorMessage;
import com.example.couponSpring.exceptions.SystemException;
import com.example.couponSpring.repos.CouponRepository;
import com.example.couponSpring.repos.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@NoArgsConstructor
public class CustomerServiceImpl extends ClientService implements CustomerService {

    private Customer customer;

    public CustomerServiceImpl(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void purchaseCoupon(Coupon coupon) throws SystemException {
        if (customerRepository.existsByCustomerAndCoupon(customer.getId(), coupon.getId())) {
            throw new SystemException(ErrorMessage.CUSTOMER_ALREADY_HAVE_COUPON);
        }
        if (coupon.getAmount() == 0) {
            throw new SystemException(ErrorMessage.NO_COUPON_LEFT);
        }
        if (coupon.getEndDate().before(Date.valueOf(LocalDate.now()))) {
            throw new SystemException(ErrorMessage.COUPON_IS_DATE_EXPIRED);
        }
        Coupon couponToUpdate = couponRepository.getById(coupon.getId());
        Customer customerToUpdate = customerRepository.getById(customer.getId());
        couponToUpdate.setAmount(couponToUpdate.getAmount() - 1);
        couponRepository.saveAndFlush(couponToUpdate);
        customerToUpdate.getCoupons().add(couponToUpdate);
        customerRepository.saveAndFlush(customerToUpdate);


    }

    @Override
    public List<Coupon> getCustomerCoupons() {
        return couponRepository.findCustomerCoupons(customer.getId());
    }

    @Override
    public List<Coupon> getCustomerCouponsByCategory(Category category) {
        return couponRepository.findCustomerCouponsByCategory(customer.getId(), category.ordinal());
    }

    @Override
    public List<Coupon> getCustomerCouponsByMaxPrice(double price) {
        return couponRepository.findCustomerCouponsByMaxPrice(customer.getId(), price);
    }

    @Override
    public Customer getCustomerDetails() throws SystemException {
        return customerRepository.findById(customer.getId()).orElseThrow(() -> new SystemException(ErrorMessage.CUSTOMER_NOT_EXISTS));
    }

    @Override
    public Customer getCustomerByEmail(String email) throws SystemException {
        return customerRepository.findByEmail(email).orElseThrow(() -> new SystemException(ErrorMessage.CUSTOMER_NOT_EXISTS));
    }

}
