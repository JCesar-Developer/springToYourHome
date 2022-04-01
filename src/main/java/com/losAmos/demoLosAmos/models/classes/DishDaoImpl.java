package com.losAmos.demoLosAmos.models.classes;

import com.losAmos.demoLosAmos.models.dao.IDishDao;
import com.losAmos.demoLosAmos.models.entity.Dish;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DishDaoImpl implements IDishDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
    @Override
    public List<Dish> getAll() {
        return em.createQuery("from Dish").getResultList();
    }

}
