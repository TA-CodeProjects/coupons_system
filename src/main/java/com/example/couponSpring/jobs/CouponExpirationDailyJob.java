package com.example.couponSpring.jobs;

import com.example.couponSpring.beans.Coupon;
import com.example.couponSpring.repos.CouponRepository;
import com.example.couponSpring.utils.PrintUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class CouponExpirationDailyJob {
    private final int SECONDS = 5;
    @Autowired
    private CouponRepository couponRepository;

    @Scheduled(fixedRate = 1000 * SECONDS, initialDelay = 1000 * SECONDS)
    public void run() {
        System.out.println("Start Job");
        for (Coupon coupon : couponRepository.findByEndDateLessThan(Date.valueOf(LocalDate.now()))) {
            couponRepository.deleteById(coupon.getId());
        }
        PrintUtil.printCoupons(couponRepository.findAll());

    }
}
