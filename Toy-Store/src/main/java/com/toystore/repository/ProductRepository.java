package com.toystore.repository;

import org.springframework.data.repository.CrudRepository;
import com.toystore.entity.*;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
