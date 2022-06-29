//package com.example.couponSpring.clr;
//
//import com.example.couponSpring.beans.*;
//import com.example.couponSpring.utils.AsciiArt;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.sql.Date;
//import java.time.LocalDate;
//import java.time.temporal.ChronoUnit;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
////@Component
//@Order(2)
//@RequiredArgsConstructor
//public class InitRestTemplate implements CommandLineRunner {
//    private final RestTemplate restTemplate;
//    private final String url = "http://localhost:8080/api/admin/";
//    private final String urlCompany = "http://localhost:8080/api/company/";
//    private final String urlCustomer = "http://localhost:8080/api/customer/";
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        try {
//            AsciiArt.adminArt();
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Add Company @@@@@@@@@@@@@");
//            Company toAdd = Company.builder().name("Fox").email("fox@gmail.com").password("1234").build();
//            ResponseEntity<String> res1 = restTemplate.postForEntity(url + "company", toAdd, String.class);
//
//            System.out.println(res1.getStatusCodeValue() == HttpStatus.CREATED.value() ? "Added" : "Not Added");
//
//            printCompanies();
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Update Company @@@@@@@@@@@@@");
//            Company toUpdate = restTemplate.getForObject(url+"company/5", Company.class);
//            toUpdate.setPassword("12");
//
//            restTemplate.put(url+"company/5", toUpdate);
//
//            printCompanies();
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Delete Company @@@@@@@@@@@@@");
//            restTemplate.delete(url+"company/5");
//
//            printCompanies();
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Get One Company @@@@@@@@@@@@@");
//            Company company = restTemplate.getForObject(url +"company/1", Company.class);
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Add Customer @@@@@@@@@@@@@");
//            Customer toAdd1 = Customer.builder().firstName("Tutu").lastName("Loto").email("tutu@gmail.com").password("1234").build();
//            ResponseEntity<String> res2 = restTemplate.postForEntity(url+"customer", toAdd1, String.class);
//            System.out.println(res2.getStatusCodeValue()== HttpStatus.CREATED.value() ? "Added" : "Not Added");
//
//            printCustomer();
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Update Customer @@@@@@@@@@@@@");
//            Customer toUpdate1 = restTemplate.getForObject(url+"customer/5", Customer.class);
//            toUpdate1.setLastName("Lotomania");
//            restTemplate.put(url+"customer/5", toUpdate1);
//
//            printCustomer();
//
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Delete Customer @@@@@@@@@@@@@");
//            restTemplate.delete(url + "customer/5");
//
//            printCustomer();
//
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Get One Customer @@@@@@@@@@@@@");
//            Customer res3 = restTemplate.getForObject(url+"customer/2", Customer.class);
//
//            System.out.println(res3);
//
//            AsciiArt.companyArt();
//
//            LoginParams loginParams = new LoginParams("shara@google.com","1234");
//            ResponseEntity<String> res4 = restTemplate.postForEntity(urlCompany+"login", loginParams,String.class);
//            System.out.println(res4.getStatusCodeValue() == HttpStatus.CREATED.value() ? "Login" : "Not Login");
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Company Details @@@@@@@@@@@@@");
//            Company company1 = restTemplate.getForObject(urlCompany+"company_details", Company.class);
//            System.out.println(company1);
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Add Coupon @@@@@@@@@@@@@");
//            Coupon coupon = Coupon.builder().category(Category.Software).title("Java")
//                    .description("Java course").startDate(Date.valueOf(LocalDate.now()))
//                    .endDate(Date.valueOf(LocalDate.now().plusDays(5))).amount(5).price(100).image("coupon6").build();
//            ResponseEntity<String> res5 = restTemplate.postForEntity(urlCompany, coupon, String.class);
//            System.out.println(res5.getStatusCodeValue()==HttpStatus.CREATED.value() ? "Added" : "Not Added");
//
//            printCompanyCoupons();
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Update Coupon @@@@@@@@@@@@@");
//            Coupon toUpdate2 = restTemplate.getForObject(urlCompany+"1", Coupon.class);
//            toUpdate2.setDescription("400$ for advertising for 50$");
//            restTemplate.put(urlCompany+"1",toUpdate2);
//
//            printCompanyCoupons();
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Delete Coupon @@@@@@@@@@@@@");
//            restTemplate.delete(urlCompany+"4");
//
//            printCompanyCoupons();
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Coupons by Category @@@@@@@@@@@@@");
//            Coupon[] coupons = restTemplate.getForObject(urlCompany + "category?category={category}", Coupon[].class, "Electricity");
//            printArray(coupons);
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Coupons by Max price @@@@@@@@@@@@@");
//            Coupon[] coupons1 = restTemplate.getForObject(urlCompany + "max_price?maxPrice={maxPrice}", Coupon[].class, 59);
//            printArray(coupons);
//
//            AsciiArt.customerArt();
//
//            LoginParams loginParams1 = new LoginParams("Beni@gmail.com", "1234");
//            ResponseEntity<String> res6 = restTemplate.postForEntity(urlCustomer+"login", loginParams1, String.class);
//            System.out.println(res6.getStatusCodeValue()==HttpStatus.CREATED.value()?"Login":"Not Login");
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Customer Details @@@@@@@@@@@@@");
//            Customer customer = restTemplate.getForObject(urlCustomer+"customer_details", Customer.class);
//            System.out.println(customer);
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Purchase Coupon @@@@@@@@@@@@@");
//            Coupon coupon6 = restTemplate.getForObject(urlCompany+"6", Coupon.class);
//            restTemplate.put(urlCustomer, coupon6);
//
//            printCustomerCoupons();
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Customer Coupons by category @@@@@@@@@@@@@");
//            Coupon[] coupons2 = restTemplate.getForObject(urlCustomer+"category?category={category}", Coupon[].class, "Electricity");
//
//            printArray(coupons2);
//
//            System.out.println();
//            System.out.println("@@@@@@@@@@@@@ Customer Coupons by max price @@@@@@@@@@@@@");
//            Coupon[] coupons3 = restTemplate.getForObject(urlCustomer+"max_price?maxPrice={maxPrice}", Coupon[].class, 59);
//
//            printArray(coupons3);
//
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void printCompanies(){
//        Company[] companies = restTemplate.getForObject(url + "company", Company[].class);
//        printArray(companies);
//    }
//
//    public void printCustomer(){
//        Customer[] customers = restTemplate.getForObject(url+"customer", Customer[].class);
//        printArray(customers);
//    }
//
//    public void printCompanyCoupons(){
//        Coupon[] coupons = restTemplate.getForObject(urlCompany, Coupon[].class);
//        printArray(coupons);
//    }
//
//    public void printCustomerCoupons(){
//        Coupon[] coupons = restTemplate.getForObject(urlCustomer, Coupon[].class);
//        printArray(coupons);
//    }
//
//    public void printArray(Object[] arr){
//        List<Object> objects = Arrays.stream(arr).collect(Collectors.toList());
//        objects.forEach(System.out::println);
//    }
//}
