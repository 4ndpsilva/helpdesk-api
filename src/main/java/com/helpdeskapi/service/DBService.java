package com.helpdeskapi.service;

import com.helpdeskapi.domain.entity.Customer;
import com.helpdeskapi.domain.entity.Technician;
import com.helpdeskapi.domain.entity.Ticket;
import com.helpdeskapi.domain.enums.Priority;
import com.helpdeskapi.domain.enums.Profile;
import com.helpdeskapi.domain.enums.Status;
import com.helpdeskapi.repository.CustomerRepository;
import com.helpdeskapi.repository.TechnicianRepository;
import com.helpdeskapi.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {

    @Autowired
    private TechnicianRepository technicianRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public void initDB(){
        Technician technician = new Technician(null, "Valdir Cesar", "12345678901", "email@prov.com", "123");
        Technician technician2 = new Technician(null, "João da Silva", "88888888888", "email2@prov.com", "123");
        technician.addProfile(Profile.ADMIN);
        technician2.addProfile(Profile.TECH);

        Customer customer = new Customer(null, "Cliente 1", "99999999999", "email@provedor.com", "123");

        Ticket ticket = new Ticket(null, Priority.MIDDLE, Status.IN_PROGRESS, "Chamado 01", "Primeiro chamado", customer, technician);

        technicianRepository.saveAll(List.of(technician, technician2));
        customerRepository.saveAll((List.of(customer)));
        ticketRepository.saveAll(List.of(ticket));
    }
}