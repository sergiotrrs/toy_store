package com.toystore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.toystore.entity.*;
import com.toystore.entity.dto.CustomerDto;
import com.toystore.service.*;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins="*")
public class CustomerController {

	@Autowired
	ICustomerService customerService;	

	@GetMapping //localhost:8080/api/customer
	@ResponseBody 
	//ResponseEntity configura la respuesta http
	public ResponseEntity<?> getAllCustomer() {	
		try {
		return new ResponseEntity<Iterable<CustomerDto>>
			(customerService.findAllCustomers(), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
	}
	
	@GetMapping("/{id}") //localhost:8080/api/customer/id
	@ResponseBody
	public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<CustomerDto>( 
					customerService.convertCustomerToDto(
							customerService.findCustomerById(id)
							),
					HttpStatus.OK);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping //localhost:8080/api/customer
	@ResponseBody
	public ResponseEntity<?> addNewCustomer(@RequestBody Customer customer) {
		try {
			//Se guarda el cliente y lo retorna con el id asignado.
			return new ResponseEntity<CustomerDto>(customerService.saveCustomer(customer), HttpStatus.CREATED);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
					
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {	
		try {
			
			return new ResponseEntity<CustomerDto>(customerService.updateCustomer(customer), HttpStatus.OK);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}			
	}
	
	@DeleteMapping("/{id}") //localhost:8080/api/customer/id
	@ResponseBody
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
		try {			
			return new ResponseEntity<String>(customerService.deleteCustomerById(id), HttpStatus.OK);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
	
	}
	
}
