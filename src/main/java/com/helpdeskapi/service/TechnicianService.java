package com.helpdeskapi.service;

import com.helpdeskapi.domain.entity.Technician;
import com.helpdeskapi.repository.TechnicianRepository;
import com.helpdeskapi.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TechnicianService {
    private final TechnicianRepository repository;

    public Technician findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Técnico não encontrado"));
    }
}