package com.helpdeskapi.domain.entity;

import com.helpdeskapi.domain.enums.Profile;
import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity(name = "TB_PERSON")
public abstract class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(length = 100)
    protected String name;

    @Column(unique = true)
    protected String cpf;

    @Column(unique = true)
    protected String email;

    @Column(length = 255)
    protected String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "TB_PROFILE")
    protected Set<Integer> profiles = new HashSet<>();

    @Column(name = "CREATED_AT")
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