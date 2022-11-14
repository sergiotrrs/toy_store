package com.toystore.service;

import java.util.List;

import com.toystore.entity.Customer;
import com.toystore.entity.dto.*;

public interface ICustomerService {
	
		public List<CustomerDto> findAllCustomers() throws Exception;
		
		public Customer findCustomerById(Long id)throws Exception;
		
		public CustomerDto findCustomerByEmail(AuthCustomer authCustomer);		
		
		public boolean existsCustomerById(Long id);
		
		public boolean existsCustomerByEmail(String email);
		
		public CustomerDto saveCustomer(Customer customer) throws Exception;
		
		public CustomerDto updateCustomer(Customer customer) throws Exception;
		
		public String deleteCustomerById(Long id) throws Exception;
		
		public CustomerDto convertCustomerToDto(Customer customer);
		
		public List<CustomerDto> convertAllCustomersToDto(List<Customer> customers);
}
