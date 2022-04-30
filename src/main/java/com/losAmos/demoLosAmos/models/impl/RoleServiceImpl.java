package com.losAmos.demoLosAmos.models.impl;

import com.losAmos.demoLosAmos.models.entity.Role;
import com.losAmos.demoLosAmos.models.repository.RoleDaoAPI;
import com.losAmos.demoLosAmos.models.services.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Long> {

    @Autowired
    private RoleDaoAPI roleDaoAPI;

    @Override
    public CrudRepository<Role, Long> getDao() {
        return roleDaoAPI;
    }
}
