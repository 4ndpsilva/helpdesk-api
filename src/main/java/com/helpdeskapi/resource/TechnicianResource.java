package com.helpdeskapi.resource;

import com.helpdeskapi.domain.entity.Technician;
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

    @GetMapping("/{id}")
    public ResponseEntity<Technician> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
}