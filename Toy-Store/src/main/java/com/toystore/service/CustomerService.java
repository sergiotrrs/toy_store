package com.toystore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toystore.entity.*;
import com.toystore.repository.*;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Iterable<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findCustomerById(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> 
				new IllegalStateException
				("The user with id " + id + " does not exist"));
	}

	@Override
	public Customer findCustomerByEmail(Customer customer) {
		return customerRepository.findByEmail(customer.getEmail());
	}
	
	@Override
	public boolean existsCustomerById(Long id) {
		return customerRepository.existsById(id);
	}

	@Override
	public boolean existsCustomerByEmail(String email) {
		return customerRepository.existsByEmail(email);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	@Override
	public Customer updateCustomer(Customer customer) throws IllegalStateException {			
		Customer customerInDatabase = findCustomerById(customer.getCustomerId());		
		customerInDatabase.setFirstName(customer.getFirstName());
		customerInDatabase.setLastName(customer.getLastName());
		customerInDatabase.setAvatar(customer.getAvatar());
		customerInDatabase.setAddress(customer.getAddress());				
		return customerRepository.save(customerInDatabase);		
	}
	
	@Override
	public String deleteCustomerById(Long id) throws IllegalStateException {
		if(!existsCustomerById(id))		
			new IllegalStateException("The user with id " + id + " does not exist");
		customerRepository.deleteById(id);
		return "The customer has been deleted";
		
		
		

	}


}
