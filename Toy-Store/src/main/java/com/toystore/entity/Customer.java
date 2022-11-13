package com.toystore.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Long customerId;
	@Column(name="first_name", length=150)
	private String firstName;
	@Column(name="last_name", length=150)
	private String lastName;
	@Column(name="avatar", length=150)
	private String avatar;
	@NotNull 
	@Column(name="email", length=150, updatable=false)	
	private String email;
	@NotNull 
	@Column(name="password", length=150, updatable=false)	
	private String password;
	@Column(name="address", length=200)
	private String address;
	
	
	
}
