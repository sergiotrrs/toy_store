package com.toystore.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import com.toystore.entity.abstract_class.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="customer")
public class Customer extends CustomerAbstract {
	
	@NotNull 
	@Column(name="password", updatable=false, length=PASSWORD_MAX_LENGTH)	
	private String password;
	@Column(name="is_active")
	protected Boolean isActive;
	
}
