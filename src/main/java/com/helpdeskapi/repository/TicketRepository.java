package com.helpdeskapi.repository;

import com.helpdeskapi.domain.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> { }