package com.helpdeskapi.repository;

import com.helpdeskapi.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> { }