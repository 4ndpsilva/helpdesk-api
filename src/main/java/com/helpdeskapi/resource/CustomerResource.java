package com.helpdeskapi.resource;

import com.helpdeskapi.domain.entity.Customer;
import com.helpdeskapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerResource {
    private final CustomerService service;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
}