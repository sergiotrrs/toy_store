package com.toystore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.toystore.entity.*;
import com.toystore.service.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customer/{id}") //localhost:8080/api/customer/id
	public @ResponseBody Customer getCustomerById(@PathVariable("id") Long id) {
		return customerService.findCustomerById(id);
	}
	
	@GetMapping("/customer") //localhost:8080/api/customer
	public @ResponseBody Iterable<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}
	
	
}
