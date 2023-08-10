package com.oriz.backend_system.controllers;

import com.oriz.backend_system.exception.CustomerException;
import com.oriz.backend_system.model.Customer;
import com.oriz.backend_system.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/profile")
    public ResponseEntity<Customer> findProfileUserByJwtHandler(
            @RequestHeader("Authorization") String jwt) throws CustomerException {
        Customer customer = customerService.findUserProfileByJwt(jwt);
        return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomerProfile(
            @RequestHeader("Authorization") String jwt,
            @RequestBody Customer updatedCustomer) throws CustomerException {
        Customer customer = customerService.updateCustomer(jwt, updatedCustomer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCustomerProfile(
            @RequestHeader("Authorization") String jwt) throws CustomerException {
        customerService.deleteCustomer(jwt);
        return new ResponseEntity<>("Customer profile deleted", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

}
