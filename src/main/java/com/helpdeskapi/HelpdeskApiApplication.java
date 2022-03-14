package com.helpdeskapi;

import com.helpdeskapi.domain.entity.Customer;
import com.helpdeskapi.domain.entity.Technician;
import com.helpdeskapi.domain.entity.Ticket;
import com.helpdeskapi.domain.enums.Priority;
import com.helpdeskapi.domain.enums.Profile;
import com.helpdeskapi.domain.enums.Status;
import com.helpdeskapi.repository.CustomerRepository;
import com.helpdeskapi.repository.PersonRepository;
import com.helpdeskapi.repository.TechnicanRepository;
import com.helpdeskapi.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HelpdeskApiApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private TechnicanRepository technicanRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private TicketRepository ticketRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Technician technician = new Technician(null, "Valdir Cesar", "12345678901", "email@prov.com", "123");
		technician.addProfile(Profile.ADMIN);

		Customer customer = new Customer(null, "Cliente 1", "99999999999", "email@provedor.com", "123");

		Ticket ticket = new Ticket(null, Priority.MIDDLE, Status.IN_PROGRESS, "Chamado 01", "Primeiro chamado", customer, technician);

		technicanRepository.saveAll(List.of(technician));
		customerRepository.saveAll((List.of(customer)));
		ticketRepository.saveAll(List.of(ticket));
	}
}