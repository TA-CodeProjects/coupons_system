package com.example.couponSpring.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    private String email;
    @Size(min = 4, max = 20)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "customers_vs_coupons",
    joinColumns = @JoinColumn(name = "customer_id"),
    inverseJoinColumns = @JoinColumn(name = "coupon_id"))
    @Singular
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<Coupon> coupons = new HashSet<>();

}

