package com.losAmos.demoLosAmos.models.repository;

import com.losAmos.demoLosAmos.models.entity.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartDaoAPI extends CrudRepository<Cart, Long> {
}
