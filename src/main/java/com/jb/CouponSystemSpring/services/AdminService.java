package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.exceptions.CouponException;

import java.util.List;

public interface AdminService {

    void addCompany(Company company) throws CouponException;

    void updateCompany(int companyId, Company company) throws CouponException;

    void deleteCompany(int companyId) throws CouponException;

    List<Company> getAllCompanies();

    Company getCompanyById(int companyId) throws CouponException;

    void addCustomer(Customer customer) throws CouponException;

    void updateCustomer(int customerId, Customer customer) throws CouponException;

    void deleteCustomer(int customerId) throws CouponException;

    List<Customer> getAllCustomers();

    Customer getCustomerById(int customerId) throws CouponException;
}
