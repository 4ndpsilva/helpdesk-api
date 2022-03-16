package com.helpdeskapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.helpdeskapi.domain.enums.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class TechnicianDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private Set<Integer> profiles = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt = LocalDate.now();

    public Set<Profile> getProfiles(){
        return profiles.stream()
                .map(x -> Profile.toEnum(x))
                .collect(Collectors.toSet());
    }

    public void addProfile(Profile profile){
        profiles.add(profile.getCode());
    }
}