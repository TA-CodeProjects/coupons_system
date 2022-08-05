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
        Company company1 = Company.builder().name("Busi").email("busi@gmail.com").password("1234").build();
        Company company2 = Company.builder().name("Kisar").email("kisar@gmail.com").password("1234").build();
        Company company3 = Company.builder().name("Mutasfi").email("mutasfi@gmail.com").password("1234").build();
        Company company4 = Company.builder().name("Dileks").email("dileks@gmail.com").password("1234").build();
        Company company5 = Company.builder().name("Hasaluf").email("hasaluf@gmail.com").password("1234").build();
        Company company6 = Company.builder().name("Hummus Hahagana").email("hummus_hahagana@gmail.com").password("1234").build();
        Company company7 = Company.builder().name("Malbi").email("malbi@gmail.com").password("1234").build();
        Company company8 = Company.builder().name("Rimon").email("rimon@gmail.com").password("1234").build();
        Company company9 = Company.builder().name("Zion").email("zion@gmail.com").password("1234").build();

//        Customer customer1 = new Customer("Roni","Chen","roni@gmail.com","1234");

        Customer customer1 = Customer.builder().firstName("Roni").lastName("Chen").email("roni@gmail.com").password("1234").build();
        Customer customer2 = Customer.builder().firstName("Moshe").lastName("Chen").email("moshe@gmail.com").password("1234").build();
        Customer customer3 = Customer.builder().firstName("Beni").lastName("Ben").email("Beni@gmail.com").password("1234").build();
        Customer customer4 = Customer.builder().firstName("Dana").lastName("Dan").email("Dana@gmail.com").password("1234").build();

//            Coupon coupon1 = new Coupon(company1,Category.Food, "Meal deal", "Main course + 2 extras + drink + coffee",
//                    Date.valueOf(LocalDate.now()),
//                    Date.valueOf(LocalDate.now().plusDays(10)),20, 70,"image1");
//        Coupon coupon2 =  new Coupon(company2, Category.Food,"Meal deal","Main course + 2 extras + drink + coffee",
//                Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now().plusDays(20)),16,60,"kisar.png");
        Coupon coupon1 = Coupon.builder().category(Category.Food).title("Busi meal deal")
                .description("Main course + 2 extras + drink + coffe").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(10))).amount(20).price(70).image("busi.png").build();
        Coupon coupon2 = Coupon.builder().category(Category.Food).title("Kisar meal deal")
                .description("Main course + 2 extras + drink + coffe").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(20))).amount(16).price(60).image("kisar.png").build();
        Coupon coupon3 = Coupon.builder().category(Category.Food).title("Mutasfi meal deal")
                .description("Main course + 2 extras + drink + coffe").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(15))).amount(18).price(50).image("mutsafi.png").build();
        Coupon coupon4 = Coupon.builder().category(Category.Food).title("Dileks bourekas")
                .description("Dileks bourekas with egg").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(30))).amount(10).price(20).image("dileks.png").build();
        Coupon coupon5 = Coupon.builder().category(Category.Food).title("Hasaluf kobane")
                .description("Kobane with egg and drink").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(5))).amount(5).price(25).image("hasaluf.png").build();
        Coupon coupon6 = Coupon.builder().category(Category.Food).title("Hummus Hahagana")
                .description("Hummus + 6 falafels + small salad").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(5))).amount(5).price(35).image("hummus_hahagana.png").build();
        Coupon coupon7 = Coupon.builder().category(Category.Desserts).title("Malbi")
                .description("Malbi with all the extras").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(5))).amount(5).price(10).image("malbi.png").build();
        Coupon coupon8 = Coupon.builder().category(Category.Beverages).title("Fresh juice")
                .description("Fresh juice rimons or oranges or carts").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(5))).amount(5).price(10).image("rimon.png").build();
        Coupon coupon9 = Coupon.builder().category(Category.Food).title("Zion sabich")
                .description("Pita sabich + drink").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(5))).amount(23).price(20).image("zion.png").build();
        Coupon coupon10 = Coupon.builder().category(Category.Beverages).title("Zion sabich drink")
                .description("Cold drink").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(5))).amount(23).price(5).image("zion.png").build();
        Coupon coupon11 = Coupon.builder().category(Category.Desserts).title("Zion sabich desert")
                .description("Bavaria").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(5))).amount(23).price(8).image("zion.png").build();

        try {

            AsciiArt.adminArt();

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Add Company @@@@@@@@@@@@@");
            adminService.addCompany(company1);
            adminService.addCompany(company2);
            adminService.addCompany(company3);
            adminService.addCompany(company4);
            adminService.addCompany(company5);
            adminService.addCompany(company6);
            adminService.addCompany(company7);
            adminService.addCompany(company8);
            adminService.addCompany(company9);

            System.out.println();
            PrintUtil.printCompanies(adminService.getAllCompanies());

//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Update Company @@@@@@@@@@@@@");
//            System.out.println();
//            company4 = adminService.getOneCompany(4);
//            company4.setEmail("moshe@wix.com");
//            adminService.updateCompany(company4);
//
//            System.out.println();
//            PrintUtil.printCompanies(adminService.getAllCompanies());
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Delete Company @@@@@@@@@@@@@");
//            adminService.deleteCompany(4);
//
//            System.out.println();
//            PrintUtil.printCompanies(adminService.getAllCompanies());

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Add Customer @@@@@@@@@@@@@");
            adminService.addCustomer(customer1);
            adminService.addCustomer(customer2);
            adminService.addCustomer(customer3);
            adminService.addCustomer(customer4);

            System.out.println();
            PrintUtil.printCustomers(adminService.getAllCustomer());

//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Update Customer @@@@@@@@@@@@@");
//            Customer customer = adminService.getOneCustomer(1);
//            customer.setFirstName("Roniyahoo");
//            adminService.updateCustomer(customer);
//
//            System.out.println();
//            PrintUtil.printCustomers(adminService.getAllCustomer());
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Delete Customer @@@@@@@@@@@@@");
//            adminService.deleteCustomer(1);
//
//            System.out.println();
//            PrintUtil.printCustomers(adminService.getAllCustomer());

            AsciiArt.companyArt();
            companyService.setCompany(companyService.getCompanyByEmail(company1.getEmail()));

//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Company Detail @@@@@@@@@@@@@");
//            System.out.println();
//            System.out.println(companyService.getCompanyDetails());


            companyService.addCoupon(coupon1);
            companyService.setCompany(companyService.getCompanyByEmail(company2.getEmail()));
            companyService.addCoupon(coupon2);
//
            companyService.setCompany(companyService.getCompanyByEmail(company3.getEmail()));
            companyService.addCoupon(coupon3);

            companyService.setCompany(companyService.getCompanyByEmail(company4.getEmail()));
            companyService.addCoupon(coupon4);

            companyService.setCompany(companyService.getCompanyByEmail(company5.getEmail()));
            companyService.addCoupon(coupon5);

            companyService.setCompany(companyService.getCompanyByEmail(company6.getEmail()));
            companyService.addCoupon(coupon6);

            companyService.setCompany(companyService.getCompanyByEmail(company7.getEmail()));
            companyService.addCoupon(coupon7);

            companyService.setCompany(companyService.getCompanyByEmail(company8.getEmail()));
            companyService.addCoupon(coupon8);

            companyService.setCompany(companyService.getCompanyByEmail(company9.getEmail()));
            companyService.addCoupon(coupon9);
            companyService.addCoupon(coupon10);
            companyService.addCoupon(coupon11);

//            System.out.println();
//            PrintUtil.printCoupons(companyService.getCompanyCoupons());
//
            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Update Coupon @@@@@@@@@@@@@");
//            Coupon toUpdate = companyService.getOneCoupon(9);
            coupon9.setDescription("updated");
            coupon9.setPrice(20);
            companyService.updateCoupon(coupon9);

            System.out.println();
            PrintUtil.printCoupons(companyService.getCompanyCoupons());
            System.out.println(coupon9);
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Delete Coupon @@@@@@@@@@@@@");
//            companyService.deleteCoupon(2);
//
//            System.out.println();
//            PrintUtil.printCoupons(companyService.getCompanyCoupons());
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Company Coupons by Category @@@@@@@@@@@@@");
//            System.out.println();
//            PrintUtil.printCoupons(companyService.getCompanyCouponsByCategory(Category.Software));
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Company Coupons by Max Price @@@@@@@@@@@@@");
//            System.out.println();
//            PrintUtil.printCoupons(companyService.getCompanyCouponsByMaxPrice(100));

            AsciiArt.customerArt();
            customerService.setCustomer(customerService.getCustomerByEmail(customer1.getEmail()));

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Customer Detail @@@@@@@@@@@@@");
            System.out.println();
            System.out.println(customerService.getCustomerDetails());

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Customer Coupons @@@@@@@@@@@@@");

            customerService.purchaseCoupon(coupon1);
            customerService.purchaseCoupon(coupon2);
            customerService.purchaseCoupon(coupon3);
//
            System.out.println();
            PrintUtil.printCoupons(customerService.getCustomerCoupons());
//
            customerService.setCustomer(customerService.getCustomerByEmail(customer2.getEmail()));

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Customer Detail @@@@@@@@@@@@@");
            System.out.println();
            System.out.println(customerService.getCustomerDetails());

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Customer Coupons @@@@@@@@@@@@@");

            customerService.purchaseCoupon(coupon4);
            customerService.purchaseCoupon(coupon5);
            customerService.purchaseCoupon(coupon6);

            System.out.println();
            PrintUtil.printCoupons(customerService.getCustomerCoupons());

            customerService.setCustomer(customerService.getCustomerByEmail(customer3.getEmail()));

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Customer Detail @@@@@@@@@@@@@");
            System.out.println();
            System.out.println(customerService.getCustomerDetails());

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Customer Coupons @@@@@@@@@@@@@");

            customerService.purchaseCoupon(coupon7);
            customerService.purchaseCoupon(coupon8);
            customerService.purchaseCoupon(coupon9);

            System.out.println();
            PrintUtil.printCoupons(customerService.getCustomerCoupons());

            customerService.setCustomer(customerService.getCustomerByEmail(customer4.getEmail()));

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Customer Detail @@@@@@@@@@@@@");
            System.out.println();
            System.out.println(customerService.getCustomerDetails());

            System.out.println();
            System.out.println("@@@@@@@@@@@@@ Customer Coupons @@@@@@@@@@@@@");

            customerService.purchaseCoupon(coupon1);
            customerService.purchaseCoupon(coupon2);
            customerService.purchaseCoupon(coupon3);

            System.out.println();
            PrintUtil.printCoupons(customerService.getCustomerCoupons());

//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Customer Coupon by Category @@@@@@@@@@@@@");
//
//            System.out.println();
//            PrintUtil.printCoupons(customerService.getCustomerCouponsByCategory(Category.Electricity));
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Customer Coupon by Max Price @@@@@@@@@@@@@");
//
//            System.out.println();
//            PrintUtil.printCoupons(customerService.getCustomerCouponsByMaxPrice(100));


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
