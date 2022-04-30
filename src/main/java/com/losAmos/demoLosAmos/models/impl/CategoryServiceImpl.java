package com.losAmos.demoLosAmos.models.impl;

import com.losAmos.demoLosAmos.models.repository.CategoryDaoAPI;
import com.losAmos.demoLosAmos.models.entity.Category;
import com.losAmos.demoLosAmos.models.services.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category, Long> {

    @Autowired
    private CategoryDaoAPI categoryDaoAPI;


    @Override
    public CrudRepository<Category, Long> getDao() {
        return categoryDaoAPI;
    }
}
