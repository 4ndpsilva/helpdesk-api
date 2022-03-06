package com.helpdeskapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Priority {
    LOW(0, "LOW"),
    MIDDLE(1, "MIDDLE"),
    HIGH(2, "HIGH");

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

        throw new IllegalArgumentException("Invalid Priority");
    }
}