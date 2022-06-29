package com.example.couponSpring.utils;

import com.example.couponSpring.beans.Company;
import com.example.couponSpring.beans.Coupon;
import com.example.couponSpring.beans.Customer;

import java.util.List;

public class PrintUtil {
    public static void printCompanies(List<Company> companies) {
        System.out.println(String.format("%-10s%-20s%-30s%-20s", "Id", "Name", "Email", "Password"));
        System.out.println("-------------------------------------------------------------------------");
        for (Company c : companies) {
            System.out.println(String.format("%-10d%-20s%-30s%-20s", c.getId(), c.getName(), c.getEmail(), c.getPassword()));
        }
    }

    public static void printCustomers(List<Customer> customers) {
        System.out.println(String.format("%-10s%-20s%-20s%-30s%-20S", "Id", "First Name", "Last Name", "Email", "Password"));
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (Customer c : customers) {
            System.out.println(String.format("%-10d%-20s%-20s%-30s%-20S", c.getId(), c.getFirstName(), c.getLastName(), c.getEmail(), c.getPassword()));
        }
    }

    public static void printCoupons(List<Coupon> coupons) {
        System.out.println(String.format("%-10s%-15s%-15s%-20s%-30s%-20s%-20s%-10s%-10s%-20s", "Id", "Company Id", "Category Id", "Title", "Description", "Start Date", "End Date", "Amount", "Price", "Image"));
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Coupon c : coupons) {
            System.out.println(String.format("%-10d%-15s%-15s%-20s%-30s%-20s%-20s%-10d%-10.2f%-20s", c.getId(), c.getCompany().getId(), c.getCategory().name(), c.getTitle(), c.getDescription(), FormatDate.format(c.getStartDate()), FormatDate.format(c.getEndDate()), c.getAmount(),c.getPrice(),c.getImage()));
        }
    }
}
