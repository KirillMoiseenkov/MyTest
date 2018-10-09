package com.company.mytest.service;

import com.company.mytest.entity.City;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.global.Scripting;
import groovy.lang.Binding;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.io.File;
import java.util.*;

@Service(CityService.NAME)
public class CityServiceBean implements CityService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CityServiceBean.class);

    @Inject
    Persistence persistence;

    @Override
    @Transactional(readOnly = true)
    public City getDefaultCity() {
        City city;
        try {
            city = (City) persistence.getEntityManager().createQuery("select e from mytest$City e where e.defaultCity = TRUE").getSingleResult();
            return city;
        } catch (NoResultException e) {
            log.error("the list of cities is empty: " + e);

            return null;
        }
    }


    @Override
    @Transactional
    public void resetDefaultCity(UUID id) {

        Query query = persistence.getEntityManager().createQuery("UPDATE mytest$City e SET e.defaultCity = FALSE WHERE e.id <> :id")
                .setParameter("id", id);

        query.executeUpdate();
    }

    @Inject
    Scripting scripting;

    @Transactional(readOnly = true)
    public void getAllCity(){

        scripting.runGroovyScript("bitdDayCongratulation.groovy",new Binding());


        List list = persistence.getEntityManager().createNativeQuery("select * from MYTEST_EMPLOYEE").getResultList();

        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Object[] row = (Object[]) it.next();
            Date date = (Date) row[10];
            System.out.println(date);
        }

    }

}