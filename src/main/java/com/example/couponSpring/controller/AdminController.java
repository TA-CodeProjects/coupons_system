package com.example.couponSpring.controller;

import com.example.couponSpring.beans.Company;
import com.example.couponSpring.beans.Customer;
import com.example.couponSpring.exceptions.SystemException;
import com.example.couponSpring.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AdminController {
    private final AdminService adminService;

    @PostMapping("company")
    @ResponseStatus(HttpStatus.CREATED)
    public Company addCompany(@RequestBody Company company) throws SystemException {
       return adminService.addCompany(company);
    }

    @PutMapping("company/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompany(@PathVariable int id, @RequestBody Company company) throws SystemException {
        adminService.updateCompany(company);
    }

    @DeleteMapping("company/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable int id) throws SystemException {
        adminService.deleteCompany(id);
    }

    @GetMapping("company")
    public List<Company> getAllCompanies(){
        return adminService.getAllCompanies();
    }

    @GetMapping("company/{id}")
    public Company getOneCompany(@PathVariable int id) throws SystemException {
        return adminService.getOneCompany(id);
    }

    @PostMapping("customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) throws SystemException {
       return adminService.addCustomer(customer);
    }

    @PutMapping("customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable int id, @RequestBody Customer customer) throws SystemException {
        adminService.updateCustomer(customer);
    }

    @DeleteMapping("customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) throws SystemException {
        adminService.deleteCustomer(id);
    }

    @GetMapping("customer")
    public List<Customer> getAllCustomer(){
        return adminService.getAllCustomer();
    }

    @GetMapping("customer/{id}")
    public Customer getOneCustomer(@PathVariable int id) throws SystemException {
        return adminService.getOneCustomer(id);
    }




}
