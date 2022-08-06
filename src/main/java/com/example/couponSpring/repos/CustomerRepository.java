package com.example.couponSpring.repos;

import com.example.couponSpring.beans.Coupon;
import com.example.couponSpring.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean existsByEmail(String email);
    boolean existsById(int id);
    boolean existsByEmailAndPassword(String email, String password);
    @Query(value = "SELECT CASE WHEN exists (SELECT * FROM `customers_vs_coupons` where customer_id = ? and coupon_id = ?) then 'true' else 'false' end",
            nativeQuery = true)
    boolean existsByCustomerAndCoupon(int customerId, int couponId);
    Optional<Customer> findByEmail(String email);




}
