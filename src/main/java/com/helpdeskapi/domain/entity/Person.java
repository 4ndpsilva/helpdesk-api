package com.helpdeskapi.domain.entity;

import com.helpdeskapi.domain.enums.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public abstract class Person {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private Profile profiles;
    private LocalDate createdAt;

    public Person(){

    }

    public void addProfile(){}
}