package com.toystore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.toystore.entity.*;
import com.toystore.entity.dto.AuthCustomer;
import com.toystore.entity.dto.CustomerDto;
import com.toystore.repository.*;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<CustomerDto> findAllCustomers() throws Exception {		
//		List<Customer> customers = (List<Customer>) customerRepository.findAll();			
//		List<Customer> customers = (List<Customer>) customerRepository.findByIsActive(true);			
		List<Customer> customers = (List<Customer>) customerRepository.findByIsActiveOrderByLastNameAsc(true);			
		return convertAllCustomersToDto(customers);
	}

	@Override
	public Customer findCustomerById(Long id) throws Exception {		
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> 
				new IllegalStateException
				("The user with id " + id + " does not exist"));
		if (!customer.getIsActive())
			throw new IllegalStateException("The user with id " + id + " does not active");
		return customer;
	}

	@Override
	public CustomerDto findCustomerByEmail(AuthCustomer authCustomer) {
		Customer customer = customerRepository.findByEmail(authCustomer.getUsername())
				.orElseThrow( () ->
				new IllegalStateException
				("The email " + authCustomer.getUsername() + "does not exists"));
		if (!customer.getPassword().equals(authCustomer.getPassword()))
			throw new IllegalStateException("Wrong password");
			
		return convertCustomerToDto(customer);
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
	public CustomerDto saveCustomer(Customer customer) throws Exception {					
		if (!(customer.getFirstName().length() < Customer.FIRST_NAME_MAX_LENGTH))			
			throw new IllegalStateException("Name length is greater than "+ Customer.FIRST_NAME_MAX_LENGTH);
		else if(!(customer.getLastName().length() < Customer.LASTNAME_MAX_LENGTH))			
			throw new IllegalStateException("Lastname length is greater than "+ Customer.LASTNAME_MAX_LENGTH);
				
		customer.setIsActive(true);
		return convertCustomerToDto(customerRepository.save(customer));		
	}
	
	@Override
	public CustomerDto updateCustomer(Customer customer) throws Exception {			
		Customer customerInDatabase = findCustomerById(customer.getCustomerId());		
		customerInDatabase.setFirstName(customer.getFirstName());
		customerInDatabase.setLastName(customer.getLastName());
		customerInDatabase.setAvatar(customer.getAvatar());
		customerInDatabase.setAddress(customer.getAddress());
		customerInDatabase.setIsActive(true);				
		return saveCustomer(customerInDatabase);	
	}
	
	@Override
	public String deleteCustomerById(Long id) throws Exception {
		Customer customerInDatabase = findCustomerById(id);
		customerInDatabase.setIsActive(false);		
		customerRepository.save(customerInDatabase);
		return "The customer has been deleted";						
	}

	@Override
	public CustomerDto convertCustomerToDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();		
		customerDto.setCustomerId(customer.getCustomerId());
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setEmail(customer.getEmail());
		customerDto.setAddress(customer.getAddress());
		customerDto.setAvatar(customer.getAvatar());						
		return customerDto;
	}

	@Override
	public List<CustomerDto> convertAllCustomersToDto(List<Customer> customers) {
		List<CustomerDto> customersDto = new ArrayList<CustomerDto>(); 
		for (Customer customer: customers ){
			customersDto.add( convertCustomerToDto(customer));
		}
		return customersDto;
	}


}
