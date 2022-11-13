package com.toystore.service;

import com.toystore.entity.Customer;

public interface ICustomerService {
	
		public Iterable<Customer> findAllCustomers();
		
		public Customer findCustomerById(Long id);
		
		public Customer findCustomerByEmail(Customer customer);		
		
		public boolean existsCustomerById(Long id);
		
		public boolean existsCustomerByEmail(String email);
		
		public Customer saveCustomer(Customer customer);
		
		public Customer updateCustomer(Customer customer);
		
		public String deleteCustomerById(Long id);
		
}
