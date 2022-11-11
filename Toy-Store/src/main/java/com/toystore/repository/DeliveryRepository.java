package com.toystore.repository;

import org.springframework.data.repository.CrudRepository;
import com.toystore.entity.*;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {

}
