package com.toystore.entity;

import java.util.Calendar;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="shopping_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;	
	
	@Column(name = "created_at", insertable=false,  updatable=false , columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customerId;
}
