package com.helpdeskapi.service;

import com.helpdeskapi.domain.entity.Customer;
import com.helpdeskapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;

    public Customer findById(Long id){
        return repository.findById(id).orElse(null);
    }
}