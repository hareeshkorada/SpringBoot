package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Customer;
import net.javaguides.springboot.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	private CustomerService customerservice;
	
	
	public CustomerController(CustomerService customerservice) {
		super();
		this.customerservice = customerservice;
	}

	
	
	@GetMapping("all")
	public List<Customer> getAllCustomers()
	{
		return customerservice.getAll();
	}
	
	@PostMapping("create")	
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer)
	{
		return new ResponseEntity<Customer>(customerservice.saveCustomer(customer), HttpStatus.CREATED);
	}
	
	@PutMapping("update")	
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)
	{
		
		return new ResponseEntity<Customer>(customerservice.updateCustomer(customer), HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{name}")
	public ResponseEntity<String> deleteCustomer(@PathVariable String  name)
	{
		customerservice.deleteCustomer(name);
		return new ResponseEntity<String>("Customer Deleted", HttpStatus.OK);
	}

}
