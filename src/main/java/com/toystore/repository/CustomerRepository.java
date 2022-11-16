package com.toystore.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.toystore.entity.*;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	Optional<Customer> findByEmail(String email);
	Iterable<Customer> findByIsActive(Boolean state);
	Iterable<Customer> findByIsActiveOrderByLastNameAsc(Boolean state);
	boolean existsByEmail(String email);
	

}
