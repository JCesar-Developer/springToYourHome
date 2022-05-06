package com.losAmos.demoLosAmos.models.impl;

import com.losAmos.demoLosAmos.models.entity.Cart;
import com.losAmos.demoLosAmos.models.entity.Category;
import com.losAmos.demoLosAmos.models.repository.CartDaoAPI;
import com.losAmos.demoLosAmos.models.repository.CategoryDaoAPI;
import com.losAmos.demoLosAmos.models.services.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends GenericServiceImpl<Cart, Long> {

    @Autowired
    private CartDaoAPI cartDaoAPI;


    @Override
    public CrudRepository<Cart, Long> getDao() {
        return cartDaoAPI;
    }
}
