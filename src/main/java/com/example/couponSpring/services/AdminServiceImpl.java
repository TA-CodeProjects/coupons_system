package com.example.couponSpring.services;

import com.example.couponSpring.beans.Company;
import com.example.couponSpring.beans.Customer;
import com.example.couponSpring.exceptions.ErrorMessage;
import com.example.couponSpring.exceptions.SystemException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends ClientService implements AdminService {
    @Value("${ADMIN_EMAIL}")
    private String ADMIN_EMAIL;
    @Value("${ADMIN_PASSWORD}")
    private String ADMIN_PASSWORD;


    @Override
    public boolean login(String email, String password) {
        return email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD);
    }

    @Override
    public Company addCompany(Company company) throws SystemException {
        if (companyRepository.existsByName(company.getName())) {
            throw new SystemException(ErrorMessage.NAME_ALREADY_EXISTS);
        }
        if (companyRepository.existsByEmail(company.getEmail())) {
            throw new SystemException(ErrorMessage.EMAIL_ALREADY_EXISTS);
        }
        return companyRepository.saveAndFlush(company);
    }

    @Override
    public void updateCompany(Company company) throws SystemException {
        if (!companyRepository.existsByIdAndName(company.getId(), company.getName())) {
            throw new SystemException(ErrorMessage.COMPANY_NOT_ALLOWED_UPDATE_NAME_OR_ID);
        }
        companyRepository.saveAndFlush(company);
    }

    @Override
    public void deleteCompany(int companyId) throws SystemException {
        if (!companyRepository.existsById(companyId)) {
            throw new SystemException(ErrorMessage.COMPANY_NOT_EXISTS);
        }
        companyRepository.deleteById(companyId);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getOneCompany(int companyId) throws SystemException {
        return companyRepository.findById(companyId).orElseThrow(() -> new SystemException(ErrorMessage.COMPANY_NOT_EXISTS));
    }

    @Override
    public Customer addCustomer(Customer customer) throws SystemException {
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new SystemException(ErrorMessage.CUSTOMER_NOT_EXISTS);
        }
       return customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) throws SystemException {
        if (!customerRepository.existsById(customer.getId())){
            throw new SystemException(ErrorMessage.CUSTOMER_NOT_EXISTS);
        }
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void deleteCustomer(int customerId) throws SystemException {
        if (!customerRepository.existsById(customerId)){
            throw new SystemException(ErrorMessage.CUSTOMER_NOT_EXISTS);
        }
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getOneCustomer(int customerId) throws SystemException {
        return customerRepository.findById(customerId).orElseThrow(() -> new SystemException(ErrorMessage.CUSTOMER_NOT_EXISTS));
    }
}
