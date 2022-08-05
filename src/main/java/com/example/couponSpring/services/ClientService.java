package com.example.couponSpring.services;

import com.example.couponSpring.repos.CompanyRepository;
import com.example.couponSpring.repos.CouponRepository;
import com.example.couponSpring.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public abstract class ClientService {
    @Autowired
    protected CouponRepository couponRepository;
    @Autowired
    protected CompanyRepository companyRepository;
    @Autowired
    protected CustomerRepository customerRepository;

}
