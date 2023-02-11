package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Customer;
import net.javaguides.springboot.repository.CustomerRepository;
import net.javaguides.springboot.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerrepository;

	public CustomerServiceImpl(CustomerRepository customerrepository) {
		super();
		this.customerrepository = customerrepository;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		customer.setCounter(1);
		return customerrepository.save(customer);
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return customerrepository.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer cust = customerrepository.findByName(customer.getName());
		if(cust==null)
			 throw new ResourceNotFoundException("Customer","Name",customer.getName());
		else 
			customer.setCounter(cust.getCounter()+1);
		
		return customerrepository.save(customer);
	}

	  @Override
	  public void deleteCustomer(String name) { 
		   Customer cust = customerrepository.findByName(name);
		   if(cust==null) 
			   throw new ResourceNotFoundException("Customer","Name",name);
			else {
			
				customerrepository.deleteById(name);
			}
		  	  
	  
	  }
	 

}
