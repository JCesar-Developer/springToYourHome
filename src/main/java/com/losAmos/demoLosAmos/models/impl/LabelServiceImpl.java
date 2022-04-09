package com.losAmos.demoLosAmos.models.impl;

import com.losAmos.demoLosAmos.models.dao.LabelDaoAPI;
import com.losAmos.demoLosAmos.models.entity.Label;
import com.losAmos.demoLosAmos.models.services.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl extends GenericServiceImpl<Label, Long> {

    @Autowired
    private LabelDaoAPI labelDaoAPI;

    @Override
    public CrudRepository<Label, Long> getDao() {
        return labelDaoAPI;
    }
}
