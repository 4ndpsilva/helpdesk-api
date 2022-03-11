package com.helpdeskapi.domain.entity;

import com.helpdeskapi.domain.enums.Priority;
import com.helpdeskapi.domain.enums.Status;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity(name = "TB_TICKET")
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "OPEN_DATE")
    private LocalDate openDate = LocalDate.now();

    @Column(name = "CLOSE_DATE")
    private LocalDate closeDate;

    private Priority priority;
    private Status status;
    private String title;
    private String observations;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "TECHNICIAN_ID")
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