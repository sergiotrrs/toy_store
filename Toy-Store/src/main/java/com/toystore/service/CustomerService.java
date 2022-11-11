package com.toystore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toystore.entity.*;
import com.toystore.repository.*;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public Iterable<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
	
	public Customer findCustomerById(Long id) {
		return customerRepository.findById(id).orElseThrow(
			()->new IllegalStateException
			("The user with id " + id+ " does not exist"));
	}
		
	public boolean existsCustomerById(Long id) {
		return customerRepository.existsById(id);
	}
	
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
}
