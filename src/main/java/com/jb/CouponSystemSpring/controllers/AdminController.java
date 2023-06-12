package com.jb.CouponSystemSpring.controllers;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/company")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCompany(@RequestBody Company company) throws CouponException {
        adminService.addCompany(company);
    }

    @PutMapping("/company/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompany(@RequestParam int val, @RequestBody Company company) throws CouponException {
        adminService.updateCompany(val, company);
    }

    @DeleteMapping("/company/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@RequestParam int val) throws CouponException {
        adminService.deleteCompany(val);
    }

    @GetMapping("/company")
    public List<Company> getAllCompanies() {
        return adminService.getAllCompanies();
    }

    @GetMapping("/company/id")
    public Company getCompanyById(@RequestParam int val) throws CouponException {
        return adminService.getCompanyById(val);

    }

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer) throws CouponException {
        adminService.addCustomer(customer);
    }

    @PutMapping("/customer/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestParam int val, @RequestBody Customer customer) throws CouponException {
        adminService.updateCustomer(val, customer);
    }

    @DeleteMapping("/customer/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@RequestParam int val) throws CouponException {
        adminService.deleteCustomer(val);
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return adminService.getAllCustomers();
    }

    @GetMapping("/customer/id")
    public Customer getCustomerById(@RequestParam int val) throws CouponException {
        return adminService.getCustomerById(val);
    }


}
