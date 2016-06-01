package com.spring.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.mongodb.model.Customer;
import com.spring.mongodb.repository.CustomerRepository;

@SpringBootApplication
public class AppStarter implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public void run(String... args) throws Exception {
		this.repository.deleteAll();

		// save a couple of customers
		this.repository.save(new Customer("Arun", "Kumar"));
		this.repository.save(new Customer("Chandrika", "Gowda"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : this.repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Arun'):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findByFirstName("Arun"));

		System.out.println("Customers found with findByLastName('Gowda'):");
		System.out.println("--------------------------------");
		for (Customer customer : this.repository.findByLastName("Gowda")) {
			System.out.println(customer);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(AppStarter.class, args);
	}
}
