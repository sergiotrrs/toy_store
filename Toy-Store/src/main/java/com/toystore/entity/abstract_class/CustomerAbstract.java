package com.toystore.entity.abstract_class;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class CustomerAbstract {
	public static final int FIRST_NAME_MAX_LENGTH = 150;
	public static final int LASTNAME_MAX_LENGTH = 150;
	public static final int AVATAR_MAX_LENGTH = 150;
	public static final int EMAIL_MAX_LENGTH = 150;
	public static final int PASSWORD_MAX_LENGTH = 150;
	public static final int ADDRESS_MAX_LENGTH = 200;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	protected Long customerId;
	@Column(name="first_name", length=FIRST_NAME_MAX_LENGTH)
	protected String firstName;
	@Column(name="last_name", length=LASTNAME_MAX_LENGTH)
	protected String lastName;
	@Column(name="avatar", length=AVATAR_MAX_LENGTH)
	protected String avatar;
	@NotNull 
	@Column(name="email", updatable=false, length=EMAIL_MAX_LENGTH)	
	protected String email;
	@Column(name="address", length=ADDRESS_MAX_LENGTH)
	protected String address;

}
