package com.helpdeskapi.resource;

import com.helpdeskapi.domain.dto.TechnicianDTO;
import com.helpdeskapi.mapper.TechnicianMapper;
import com.helpdeskapi.service.TechnicianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<TechnicianDTO>> findAll(){
        return ResponseEntity.ok(mapper.map(service.findAll()));
    }

    @PostMapping
    public ResponseEntity<TechnicianDTO> save(@RequestBody TechnicianDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(service.save(mapper.map(dto))));
    }
}