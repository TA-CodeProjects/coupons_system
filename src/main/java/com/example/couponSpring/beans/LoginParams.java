package com.example.couponSpring.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginParams {
    private String email;
    private String password;
    private ClientType clientType;
}
