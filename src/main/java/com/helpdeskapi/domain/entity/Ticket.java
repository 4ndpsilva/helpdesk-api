package com.helpdeskapi.domain.entity;

import com.helpdeskapi.domain.enums.Priority;
import com.helpdeskapi.domain.enums.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Ticket {
    private Long id;
    private LocalDate openDate = LocalDate.now();
    private LocalDate closeDate;
    private Priority priority;
    private Status status;
    private String title;
    private String observations;
    private Customer customer;
    private Technician technician;

    public Ticket(Long id, Priority priority, Status status, String title, String observations, Customer customer, Technician technician) {
        this.id = id;
        this.priority = priority;
        this.status = status;
        this.title = title;
        this.observations = observations;
        this.customer = customer;
        this.technician = technician;
    }
}