package com.example.couponSpring.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginParams {
    @Email
    private String email;
    @Size(min = 4, max = 20)
    private String password;
    private ClientType clientType;
}
