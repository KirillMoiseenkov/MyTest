package com.company.mytest.service;

import com.company.mytest.core.component.EmployeeBithDayDAO;
import com.haulmont.cuba.core.Persistence;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service(EmployeeService.NAME)
public class EmployeeServiceBean implements EmployeeService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CityServiceBean.class);

    private List list;

    private List<Map<String, String>> dateList;

    @Inject
    Persistence persistence;

    @Inject
    EmployeeBithDayDAO employeeBithDayDAO;

    public List getList() {
        return list;
    }

    public List<Map<String, String>> getDateList() {
        return dateList;
    }

    public void setDateList(List<Map<String, String>> dateList) {
        this.dateList = dateList;
    }

    @Override
    @Transactional
    public List<Object> updateEmploeeListByBirthDay() {

        list = employeeBithDayDAO.updateEmploeeListByBirthDay();

        return list;

    }

    @Override
    public List<Map<String, String>> castToListMap() {

        if(list == null) updateEmploeeListByBirthDay();

        dateList = new ArrayList<>();


        list.forEach(o -> {


            Object[] obj = (Object[]) o;

            Map<String, String> innerMap = new HashMap<>();

            innerMap.put("name", obj[0].toString());
            innerMap.put("lastName", obj[1].toString());
            innerMap.put("email", obj[2].toString());
            innerMap.put("carSerivce", obj[4].toString());
            innerMap.put("age", obj[5].toString());

            dateList.add(innerMap);
        });

        return dateList;

    }
}