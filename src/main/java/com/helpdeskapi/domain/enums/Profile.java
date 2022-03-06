package com.helpdeskapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Profile {
    ADMIN(0, "ROLE_ADMIN"),
    CUSTOMER(1, "ROLE_CUSTOMER"),
    TECH(2, "ROLE_TECH");

    private Integer code;
    private String description;

    public static Profile toEnum(final Integer code){
        if(code == null){
            return null;
        }

        for(Profile p : Profile.values()){
            if(code.equals(p.getCode())){
                return p;
            }
        }

        throw new RuntimeException("Invalid Profile");
    }
}