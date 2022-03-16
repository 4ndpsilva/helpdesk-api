package com.helpdeskapi.resource;

import com.helpdeskapi.domain.dto.TechnicianDTO;
import com.helpdeskapi.mapper.TechnicianMapper;
import com.helpdeskapi.service.TechnicianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/technicians")
@RequiredArgsConstructor
public class TechnicianResource {
    private final TechnicianService service;
    private final TechnicianMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<TechnicianDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(mapper.map(service.findById(id)));
    }
}