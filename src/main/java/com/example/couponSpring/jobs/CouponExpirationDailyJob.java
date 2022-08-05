package com.example.couponSpring.jobs;

import com.example.couponSpring.beans.Coupon;
import com.example.couponSpring.repos.CouponRepository;
import com.example.couponSpring.utils.PrintUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
public class CouponExpirationDailyJob {
    @Autowired
    private CouponRepository couponRepository;

    @Scheduled(cron = "${CRON_JOB}")
    public void run() {
        System.out.println("Start Job");
        List<Coupon> expiredCoupons = couponRepository.findByEndDateLessThan(Date.valueOf(LocalDate.now()));
        couponRepository.deleteAll(expiredCoupons);
        PrintUtil.printCoupons(couponRepository.findAll());

    }
}
