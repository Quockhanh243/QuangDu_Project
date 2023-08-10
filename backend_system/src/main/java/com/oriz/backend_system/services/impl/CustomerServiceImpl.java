package com.oriz.backend_system.services.impl;

import com.oriz.backend_system.config.JwtProvider;
import com.oriz.backend_system.exception.CustomerException;
import com.oriz.backend_system.model.Customer;
import com.oriz.backend_system.repositories.CustomerRepository;
import com.oriz.backend_system.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final JwtProvider jwtProvider;


    @Override
    public Customer findUserById(Long customerId) throws CustomerException {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return customer.get();
        }
        throw new CustomerException("User not found id: " + customerId);
    }

    @Override
    public Customer findUserProfileByJwt(String jwt) throws CustomerException {

        String email = jwtProvider.getEmailFromToken(jwt);

        Customer customer = customerRepository.findByEmail(email);

        if (customer == null) {
            throw new CustomerException("User not found with email" + email);
        }
        return customer;
    }

    @Override
    public Customer updateCustomer(String jwt, Customer updatedCustomer) throws CustomerException {
        Customer existingCustomer = findUserProfileByJwt(jwt);

        if (existingCustomer != null) {
            // Kiểm tra và thực hiện cập nhật thông tin khách hàng
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            // Cập nhật các trường thông tin khác

            // Lưu cập nhật vào cơ sở dữ liệu
            return customerRepository.save(existingCustomer);
        }

        throw new CustomerException("User not found !");

    }

    @Override
    public String deleteCustomer(String jwt) throws CustomerException {
        Customer customer = findUserProfileByJwt(jwt);
        if (customer != null) {
            customerRepository.delete(customer);
            return "Delete Success";
        }

        throw new CustomerException("User not found !");
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer addCustomer(Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }
}
