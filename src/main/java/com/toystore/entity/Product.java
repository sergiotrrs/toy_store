package com.toystore.entity;


import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;
	private String name;
	private Double price;

}
