package com.helpdeskapi.domain.entity;

import com.helpdeskapi.domain.enums.Profile;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "TB_TECHNICIAN")
public class Technician extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "technician")
    private List<Ticket> tickets = new ArrayList<>();

    public Technician(Long id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
        addProfile(Profile.TECH);
    }
}