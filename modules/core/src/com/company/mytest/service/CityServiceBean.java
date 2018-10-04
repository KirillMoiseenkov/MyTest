package com.company.mytest.service;

import com.company.mytest.entity.City;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import groovy.transform.ToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.util.UUID;

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
        }catch (NoResultException e) {
                log.error("the list of cities is empty: " + e);

                return null;
            }
        }



    @Override
    @Transactional
    public void resetDefaultCity(UUID id) {

        Query query = persistence.getEntityManager().createQuery("UPDATE mytest$City e SET e.defaultCity = FALSE WHERE e.id <> :id")
                .setParameter("id",id);

        query.executeUpdate();

    }


}