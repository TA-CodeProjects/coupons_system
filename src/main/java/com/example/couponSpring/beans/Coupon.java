package com.example.couponSpring.beans;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "coupons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JsonIgnore
    private Company company;
    @Enumerated(EnumType.STRING)
    private Category category;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    @Min(value = 0)
    private int amount;
    @Min(value = 0)
    private double price;
    private String image;

    @ManyToMany(mappedBy = "coupons", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    private Set<Customer> customers = new HashSet<>();
}