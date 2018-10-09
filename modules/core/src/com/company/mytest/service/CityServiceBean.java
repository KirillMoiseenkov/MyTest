package com.company.mytest.service;

import com.company.mytest.entity.City;
import com.haulmont.bali.util.ParamsMap;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

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

        List list = persistence.getEntityManager().createNativeQuery("select MYTEST_EMPLOYEE.FIRST_NAME," +
                "MYTEST_EMPLOYEE.BITH_DATE, MYTEST_CAR_SERVICE_CENTER.NAME, " +
                "to_char(extract (year from now()) - extract (year from MYTEST_EMPLOYEE.BITH_DATE), '99') as age" +
                " from MYTEST_EMPLOYEE" +
                " LEFT JOIN MYTEST_CAR_SERVICE_CENTER ON MYTEST_CAR_SERVICE_CENTER.ID = MYTEST_EMPLOYEE.CENTER_ID" +
                " WHERE extract (day from MYTEST_EMPLOYEE.BITH_DATE) = extract (day from now())" +
                " AND extract (month from MYTEST_EMPLOYEE.BITH_DATE) = extract (month from now())").getResultList();



        LocalDate localDate = LocalDate.now();

        list.forEach(o ->{

            Object[] objects = (Object[]) o;

            List<Object> objectList = Arrays.asList(objects);

            Date date = (Date) objectList.get(1);

            System.out.println(date.getDay() + " " + date.getMonth() + " "  + date.getYear());

          //  LocalDate newLocalDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        });


       /* Binding binding = new Binding();
        binding.setVariable("age","privt");


        String body = scripting.runGroovyScript("bitdDayCongratulation.groovy",binding);
*/



    }

}