package com.helpdeskapi.repository;

import com.helpdeskapi.domain.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicanRepository extends JpaRepository<Technician, Long> { }