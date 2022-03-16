package com.helpdeskapi.mapper;

import com.helpdeskapi.domain.dto.TechnicianDTO;
import com.helpdeskapi.domain.entity.Technician;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TechnicianMapper {
    Technician map(TechnicianDTO dto);

    @Mapping(target = "profiles", expression = "java(entity.getProfiles().stream().map(x -> x.getCode()).collect(java.util.stream.Collectors.toSet()))")
    TechnicianDTO map(Technician entity);

    @Mapping(target = "profiles", expression = "java(entity.getProfiles().stream().map(x -> x.getCode()).collect(java.util.stream.Collectors.toSet()))")
    List<TechnicianDTO> map(List<Technician> entities);
}