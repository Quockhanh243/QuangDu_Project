package com.oriz.backend_system.services;

import com.oriz.backend_system.exception.CustomerException;
import com.oriz.backend_system.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer findUserById(Long customerId) throws  CustomerException;
    public Customer findUserProfileByJwt(String jwt) throws  CustomerException;

    Customer updateCustomer(String jwt, Customer updatedCustomer) throws CustomerException;

    String deleteCustomer(String jwt) throws CustomerException;

    List<Customer> getAllCustomers();

    Customer addCustomer(Customer newCustomer);
}
