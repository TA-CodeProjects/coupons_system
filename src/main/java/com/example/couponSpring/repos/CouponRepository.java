package com.example.couponSpring.repos;

import com.example.couponSpring.beans.Category;
import com.example.couponSpring.beans.Company;
import com.example.couponSpring.beans.Coupon;
import com.example.couponSpring.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    List<Coupon> findByCompany(Company company);

    List<Coupon> findByCompanyAndCategory(Company company, Category category);

    List<Coupon> findByCompanyAndPriceGreaterThanEqual(Company company, double price);

    List<Coupon> findByEndDateLessThan(Date endDate);

    boolean existsByCompanyAndTitle(Company company, String title);

    boolean existsByIdAndCompany(int id, Company company);

    boolean existsByCompany(Company company);

    @Query(value = "SELECT * FROM coupons inner join customers_vs_coupons on coupons.id = customers_vs_coupons.coupon_id where customers_vs_coupons.customer_id = ?",
            nativeQuery = true)
    List<Coupon> findCustomerCoupons(int customerId);

    @Query(value = "SELECT * FROM coupons inner join `spring-147`.customers_vs_coupons on coupons.id = customers_vs_coupons.coupon_id where customers_vs_coupons.customer_id = ? and coupons.category = ?",
            nativeQuery = true)
    List<Coupon> findCustomerCouponsByCategory(int customerId, int category);
    @Query(value = "SELECT * FROM coupons inner join customers_vs_coupons on coupons.id = customers_vs_coupons.coupon_id where customers_vs_coupons.customer_id = ? and coupons.price >= ?",
            nativeQuery = true)
    List<Coupon> findCustomerCouponsByMaxPrice(int customerId, double price);



}
