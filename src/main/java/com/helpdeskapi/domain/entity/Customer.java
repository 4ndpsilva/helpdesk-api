package com.helpdeskapi.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Customer extends Person implements Serializable {
    private List<Ticket> tickets = new ArrayList<>();

    public Customer(Long id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
    }
}