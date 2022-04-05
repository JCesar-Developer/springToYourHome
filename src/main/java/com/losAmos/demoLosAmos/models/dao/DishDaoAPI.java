package com.losAmos.demoLosAmos.models.dao;

import com.losAmos.demoLosAmos.models.entity.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishDaoAPI extends CrudRepository<Dish,Long> {
}
