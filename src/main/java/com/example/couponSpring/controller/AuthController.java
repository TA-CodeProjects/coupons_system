package com.example.couponSpring.controller;

import com.example.couponSpring.beans.LoginParams;
import com.example.couponSpring.exceptions.ErrorMessage;
import com.example.couponSpring.exceptions.SystemException;
import com.example.couponSpring.repos.CompanyRepository;
import com.example.couponSpring.repos.CustomerRepository;
import com.example.couponSpring.security.JWTUtil;
import com.example.couponSpring.security.MyUserDetailsService;
import com.example.couponSpring.services.CompanyService;
import com.example.couponSpring.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authManager;
    private final MyUserDetailsService userDetailsService;
    private final CompanyService companyService;
    private final CustomerService customerService;
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;


    @PostMapping("/login")
    public Map<String, Object> createAuthenticationToken(@RequestBody LoginParams loginParams) throws Exception {
        String username = loginParams.getEmail()+":"+loginParams.getClientType().name();
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, loginParams.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        Map<String, Object> claims = new HashMap<>();
        claims.put("clientType", loginParams.getClientType().name());
        final String jwt = jwtUtil.generateToken(userDetails, claims);
        System.out.println(jwtUtil.extractUsername(jwt));

        switch (loginParams.getClientType().name()){
            case "Company":
                companyService.setCompany(companyRepository.findByEmail(jwtUtil.extractUsername(jwt))
                        .orElseThrow(() -> new SystemException(ErrorMessage.COMPANY_NOT_EXISTS)));
                break;
            case "Customer":
                customerService.setCustomer(customerRepository.findByEmail(jwtUtil.extractUsername(jwt))
                        .orElseThrow(()-> new SystemException(ErrorMessage.CUSTOMER_NOT_EXISTS)));
        }
        return Collections.singletonMap("jwt-token", jwt);
    }
}
