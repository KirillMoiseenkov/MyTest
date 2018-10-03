package com.company.mytest.service;

import com.haulmont.cuba.core.Query;
import org.springframework.stereotype.Component;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.EntityManager;
import com.company.mytest.entity.City;
import org.springframework.transaction.annotation.Transactional;

@Component("mytest_CityListener")
public class CityListener implements BeforeInsertEntityListener<City> {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CityListener.class);

    @Transactional
    @Override
    public void onBeforeInsert(City entity, EntityManager entityManager) {



     if(entity.getDefaultCity()) {

         Query query = entityManager.createQuery("UPDATE mytest$City e SET e.defaultCity = FALSE WHERE e.id <> :id")
                 .setParameter("id", entity.getId());

         log.info( ((Integer) query.executeUpdate()).toString());
     }



    }


}