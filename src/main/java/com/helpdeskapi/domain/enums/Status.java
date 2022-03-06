package com.helpdeskapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    OPEN(0, "OPEN"),
    IN_PROGRESS(1, "IN_PROGRESS"),
    CLOSE(2, "CLOSE");

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

        throw new IllegalArgumentException("Invalid Status");
    }
}