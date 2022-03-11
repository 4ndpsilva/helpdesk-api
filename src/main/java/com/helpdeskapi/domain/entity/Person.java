package com.helpdeskapi.domain.entity;

import com.helpdeskapi.domain.enums.Profile;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public abstract class Person {
    protected Long id;
    protected String name;
    protected String cpf;
    protected String email;
    protected String password;
    protected Set<Integer> profiles = new HashSet<>();
    protected LocalDate createdAt = LocalDate.now();

    public Person(){
        addProfile(Profile.CUSTOMER);
    }

    public Person(Long id, String name, String cpf, String email, String password){
        this();
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public void addProfile(final Profile profile){
        profiles.add(profile.getCode());
    }

    public Set<Profile> getProfiles(){
        return profiles.stream()
                .map(p -> Profile.toEnum(p))
                .collect(Collectors.toSet());
    }
}