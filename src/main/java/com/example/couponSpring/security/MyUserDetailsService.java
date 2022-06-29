package com.example.couponSpring.security;

import com.example.couponSpring.beans.Company;
import com.example.couponSpring.beans.Customer;
import com.example.couponSpring.repos.CompanyRepository;
import com.example.couponSpring.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

import static java.lang.String.format;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Value("${ADMIN_EMAIL}")
    private String ADMIN_EMAIL;
    @Value("${ADMIN_PASSWORD}")
    private String ADMIN_PASSWORD;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String usernamePart = null;
        if (username.contains(":")){
            int colonIndex = username.lastIndexOf(":");
            usernamePart = username.substring(0, colonIndex);
        }
        usernamePart = usernamePart == null ? username : usernamePart;
        String usertypePart = null;
        if (username.contains(":")) {
            int colonIndex = username.lastIndexOf(":");
            usertypePart = username.substring(colonIndex +1, username.length());
        }

        System.out.println(usertypePart);
        switch (usertypePart){
            case "Company":
                String finalUsernamePart = usernamePart;
                Company company = companyRepository.findByEmail(usernamePart).orElseThrow(
                        () -> new UsernameNotFoundException(format("Company: %s, not found", finalUsernamePart)));
                return new User(company.getEmail(), company.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_COMPANY")));
            case "Customer":
                String finalUsernamePart1 = usernamePart;
                Customer customer = customerRepository.findByEmail(usernamePart).orElseThrow(
                        () -> new UsernameNotFoundException(format("Customer: %s, not found", finalUsernamePart1)));
                return new User(customer.getEmail(), customer.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_CUSTOMER")));
            default:
                return new User(ADMIN_EMAIL, ADMIN_PASSWORD, Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
        }
    }


}