package com.company.mytest.core.component;

import com.haulmont.cuba.core.Persistence;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Component
public class EmployeeBithDayDAOImp implements EmployeeBithDayDAO {

    private List list;

    @Inject
    Persistence persistence;

    @Override
    public List getList() {
        return list;
    }


    @Override
    @Transactional
    public List<Object> updateEmploeeListByBirthDay() {
        list = persistence.getEntityManager().createNativeQuery("select MYTEST_EMPLOYEE.FIRST_NAME, " +
                " MYTEST_EMPLOYEE.LAST_NAME, MYTEST_EMPLOYEE.EMAIL," +
                " MYTEST_EMPLOYEE.BITH_DATE, MYTEST_CAR_SERVICE_CENTER.NAME, " +
                "to_char(extract (year from now()) - extract (year from MYTEST_EMPLOYEE.BITH_DATE), '99') as age" +
                " from MYTEST_EMPLOYEE" +
                " LEFT JOIN MYTEST_CAR_SERVICE_CENTER ON MYTEST_CAR_SERVICE_CENTER.ID = MYTEST_EMPLOYEE.CENTER_ID" +
                " WHERE extract (day from MYTEST_EMPLOYEE.BITH_DATE) = extract (day from now())" +
                " AND extract (month from MYTEST_EMPLOYEE.BITH_DATE) = extract (month from now())").getResultList();

        return list;
    }

}
