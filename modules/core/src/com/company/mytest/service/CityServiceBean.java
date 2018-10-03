package com.company.mytest.service;

import com.company.mytest.entity.City;
import com.haulmont.cuba.core.Persistence;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service(CityService.NAME)
public class CityServiceBean implements CityService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CityServiceBean.class);

    @Inject
    Persistence persistence;

    @Override
    @Transactional(readOnly = true)
    public City getDefaultCity() {

//       (City) persistence.getEntityManager().createQuery("select e from mytest$City e where e.defaultCity = TRUE").getSingleResult();

       return (City) persistence.getEntityManager().createQuery("select e from mytest$City e where e.defaultCity = TRUE").getSingleResult();


    }
}