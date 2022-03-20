package com.helpdeskapi.service;

import com.helpdeskapi.domain.entity.Technician;
import com.helpdeskapi.repository.TechnicianRepository;
import com.helpdeskapi.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnicianService {
    private final TechnicianRepository repository;

    public Technician save(Technician technician){
        return repository.save(technician);
    }

    public Technician findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Técnico não encontrado"));
    }

    public List<Technician> findAll(){
        return repository.findAll();
    }
}