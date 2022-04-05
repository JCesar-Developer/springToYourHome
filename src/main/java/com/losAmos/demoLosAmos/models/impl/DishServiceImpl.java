package com.losAmos.demoLosAmos.models.impl;

import com.losAmos.demoLosAmos.models.services.GenericServiceImpl;
import com.losAmos.demoLosAmos.models.entity.Dish;
import com.losAmos.demoLosAmos.models.dao.DishDaoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends GenericServiceImpl<Dish, Long> {

    @Autowired
    private DishDaoAPI dishDaoAPI;

    @Override
    public CrudRepository<Dish, Long> getDao() {
        return dishDaoAPI;
    }
}
