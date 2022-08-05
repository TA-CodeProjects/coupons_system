package com.example.couponSpring.services;

import com.example.couponSpring.beans.Company;
import com.example.couponSpring.beans.Customer;
import com.example.couponSpring.exceptions.SystemException;

import java.util.List;

public interface  AdminService {

    boolean login(String email, String password);

    Company addCompany(Company company) throws SystemException;

    void updateCompany(Company company) throws SystemException;

    void deleteCompany(int companyId) throws SystemException;

    List<Company> getAllCompanies();

    Company getOneCompany(int companyId) throws SystemException;

    Customer addCustomer(Customer customer) throws SystemException;

    void updateCustomer(Customer customer) throws SystemException;

    void deleteCustomer(int customerId) throws SystemException;

    List<Customer> getAllCustomer();

    Customer getOneCustomer(int customerId) throws SystemException;
}
