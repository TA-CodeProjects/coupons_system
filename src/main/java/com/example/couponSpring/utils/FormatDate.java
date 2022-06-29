package com.example.couponSpring.utils;

import java.sql.Date;

public class FormatDate {
    public static String format(Date date) {
        int day = date.toLocalDate().getDayOfMonth();
        int month = date.toLocalDate().getMonthValue();
        int year = date.toLocalDate().getYear();
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}
