package com.helpdeskapi.domain.entity;

import com.helpdeskapi.domain.enums.Priority;
import com.helpdeskapi.domain.enums.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Ticket {
    private Long id;
    private LocalDate openDate;
    private LocalDate closeDate;
    private Priority priority;
    private Status status;
    private String title;
    private String observations;
    private Customer customer;
    private Technician technician;
}