package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	Customer findByName(String name);
	
	

}
