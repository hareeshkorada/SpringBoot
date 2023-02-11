package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Customer;



public interface CustomerService {
	
	Customer saveCustomer(Customer customer);
	
	List<Customer> getAll();
	
	Customer updateCustomer(Customer customer);
	
	void deleteCustomer(String name);

}
