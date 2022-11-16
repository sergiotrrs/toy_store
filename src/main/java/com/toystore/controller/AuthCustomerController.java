package com.toystore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.toystore.entity.dto.*;
import com.toystore.service.*;

//@RestController
//@RequestMapping("/login")
//@CrossOrigin(origins="*")
public class AuthCustomerController {

	@Autowired
	ICustomerService customerService;	
		
	@PostMapping //localhost:8080/login
	@ResponseBody
	public ResponseEntity<?> loginCustomer(@RequestBody AuthCustomer authCustomer) {
		try {
			return new ResponseEntity<CustomerDto>(customerService.findCustomerByEmail(authCustomer), HttpStatus.ACCEPTED);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
					
	}
		
}
