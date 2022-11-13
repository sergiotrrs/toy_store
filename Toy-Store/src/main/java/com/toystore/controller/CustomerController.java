package com.toystore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.toystore.entity.*;
import com.toystore.service.*;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins="*")
public class CustomerController {

	@Autowired
	CustomerService customerService;	

	@GetMapping //localhost:8080/api/customer
	public @ResponseBody Iterable<Customer> getAllCustomer() {
		return customerService.findAllCustomers();
	}
	
	@GetMapping("/{id}") //localhost:8080/api/customer/id
	public @ResponseBody Customer getCustomerById(@PathVariable("id") Long id) {
		return customerService.findCustomerById(id);
	}
	
	@PostMapping //localhost:8080/api/customer
	public @ResponseBody Customer addNewCustomer(@RequestBody Customer customer) {
		//Se guarda el cliente y lo retorna con el id asignado.
		return customerService.saveCustomer(customer);
	}
	
	@PutMapping //localhost:8080/api/customer
	public @ResponseBody Customer updateCustomer(@RequestBody Customer customer) {		
		return customerService.updateCustomer(customer);
	}
	
	@DeleteMapping("/{id}") //localhost:8080/api/customer/id
	public @ResponseBody String deleteCustomer(@PathVariable("id") Long id) {
		return customerService.deleteCustomerById(id);		
	}
	
}
