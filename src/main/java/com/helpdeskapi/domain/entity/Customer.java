package com.helpdeskapi.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.helpdeskapi.domain.enums.Profile;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "TB_CUSTOMER")
public class Customer extends Person implements Serializable {
    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Ticket> tickets = new ArrayList<>();

    public Customer(Long id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
        addProfile(Profile.CUSTOMER);
    }
}