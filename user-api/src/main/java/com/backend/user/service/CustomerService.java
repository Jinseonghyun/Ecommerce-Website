package com.backend.user.service;

import com.backend.user.domain.model.Customer;
import com.backend.user.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Optional<Customer> findValidCustomer(String email, String password) {
        return customerRepository.findByEmail(email).stream()
                .filter(customer ->  customer.getPassword().equals(password) && customer.isVerify())
                .findFirst();
    }
}
