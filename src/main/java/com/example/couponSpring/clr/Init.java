package com.example.couponSpring.clr;

import com.example.couponSpring.beans.*;
import com.example.couponSpring.services.*;
import com.example.couponSpring.utils.AsciiArt;
import com.example.couponSpring.utils.PrintUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;


@Component
@Order(1)
@RequiredArgsConstructor
public class Init implements CommandLineRunner {
    private final AdminService adminService;
    private final CompanyService companyService;
    private final CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
        Company company1 = Company.builder().name("Google").email("shara@google.com").password("1234").build();
        Company company2 = Company.builder().name("Microsoft").email("dan@microsoft.com").password("1234").build();
        Company company3 = Company.builder().name("Facebook").email("shalom@facebook.com").password("1234").build();
        Company company4 = Company.builder().name("Wix").email("gidi@wix.com").password("1234").build();

        Customer customer1 = Customer.builder().firstName("Roni").lastName("Chen").email("roni@gmail.com").password("1234").build();
        Customer customer2 = Customer.builder().firstName("Moshe").lastName("Chen").email("moshe@gmail.com").password("1234").build();
        Customer customer3 = Customer.builder().firstName("Beni").lastName("Ben").email("Beni@gmail.com").password("1234").build();
        Customer customer4 = Customer.builder().firstName("Dana").lastName("Dan").email("Dana@gmail.com").password("1234").build();

        Coupon coupon1 = Coupon.builder().category(Category.Advertising).title("Advertising")
                .description("300$ for advertising for 50$").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(10))).amount(2).price(50).image("coupon1").build();
        Coupon coupon2 = Coupon.builder().category(Category.Electricity).title("Google phone1")
                .description("The new google phone1").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(20))).amount(6).price(100).image("coupon2").build();
        Coupon coupon3 = Coupon.builder().category(Category.Electricity).title("Google phone2")
                .description("The new google phone2").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(15))).amount(8).price(200).image("coupon3").build();
        Coupon coupon4 = Coupon.builder().category(Category.Software).title("Cloud storage")
                .description("5 terabyte cloud storage").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(30))).amount(10).price(20).image("coupon4").build();
        Coupon coupon5 = Coupon.builder().category(Category.Software).title("Windows")
                .description("Latest version of windows").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(5))).amount(5).price(60).image("coupon4").build();

        try {

            AsciiArt.adminArt();

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Add Company @@@@@@@@@@@@@");
            adminService.addCompany(company1);
            adminService.addCompany(company2);
            adminService.addCompany(company3);
            adminService.addCompany(company4);

            System.out.println();
            PrintUtil.printCompanies(adminService.getAllCompanies());

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Update Company @@@@@@@@@@@@@");
            System.out.println();
            company4 = adminService.getOneCompany(4);
            company4.setEmail("moshe@wix.com");
            adminService.updateCompany(company4);

            System.out.println();
            PrintUtil.printCompanies(adminService.getAllCompanies());

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Delete Company @@@@@@@@@@@@@");
            adminService.deleteCompany(4);

            System.out.println();
            PrintUtil.printCompanies(adminService.getAllCompanies());

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Add Customer @@@@@@@@@@@@@");
            adminService.addCustomer(customer1);
            adminService.addCustomer(customer2);
            adminService.addCustomer(customer3);
            adminService.addCustomer(customer4);

            System.out.println();
            PrintUtil.printCustomers(adminService.getAllCustomer());

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Update Customer @@@@@@@@@@@@@");
            Customer customer = adminService.getOneCustomer(1);
            customer.setFirstName("Roniyahoo");
            adminService.updateCustomer(customer);

            System.out.println();
            PrintUtil.printCustomers(adminService.getAllCustomer());

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Delete Customer @@@@@@@@@@@@@");
            adminService.deleteCustomer(1);

            System.out.println();
            PrintUtil.printCustomers(adminService.getAllCustomer());

            AsciiArt.companyArt();
            String companyEmail = company1.getEmail();
            companyService.setCompany(companyService.getCompanyByEmail(companyEmail));

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Company Detail @@@@@@@@@@@@@");
            System.out.println();
            System.out.println(companyService.getCompanyDetails());

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Add Coupon @@@@@@@@@@@@@");
            companyService.addCoupon(coupon1);
            companyService.addCoupon(coupon2);
            companyService.addCoupon(coupon3);
            companyService.addCoupon(coupon4);
            companyService.addCoupon(coupon5);

            System.out.println();
            PrintUtil.printCoupons(companyService.getCompanyCoupons());

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Update Coupon @@@@@@@@@@@@@");
            Coupon toUpdate = companyService.getOneCoupon(1);
            toUpdate.setDescription("200$ for advertising for 30$");
            toUpdate.setPrice(20);
            companyService.updateCoupon(toUpdate);

            System.out.println();
            PrintUtil.printCoupons(companyService.getCompanyCoupons());

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Delete Coupon @@@@@@@@@@@@@");
            companyService.deleteCoupon(2);

            System.out.println();
            PrintUtil.printCoupons(companyService.getCompanyCoupons());

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Company Coupons by Category @@@@@@@@@@@@@");
            System.out.println();
            PrintUtil.printCoupons(companyService.getCompanyCouponsByCategory(Category.Software));

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Company Coupons by Max Price @@@@@@@@@@@@@");
            System.out.println();
            PrintUtil.printCoupons(companyService.getCompanyCouponsByMaxPrice(100));

            AsciiArt.customerArt();
            String customerEmail = customer2.getEmail();
            customerService.setCustomer(customerService.getCustomerByEmail(customerEmail));

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Customer Detail @@@@@@@@@@@@@");
            System.out.println();
            System.out.println(customerService.getCustomerDetails());

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Customer Coupons @@@@@@@@@@@@@");

            customerService.purchaseCoupon(coupon1);
            customerService.purchaseCoupon(coupon3);
            customerService.purchaseCoupon(coupon5);

            System.out.println();
            PrintUtil.printCoupons(customerService.getCustomerCoupons());

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Customer Coupon by Category @@@@@@@@@@@@@");

            System.out.println();
            PrintUtil.printCoupons(customerService.getCustomerCouponsByCategory(Category.Electricity));

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Customer Coupon by Max Price @@@@@@@@@@@@@");

            System.out.println();
            PrintUtil.printCoupons(customerService.getCustomerCouponsByMaxPrice(100));


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
