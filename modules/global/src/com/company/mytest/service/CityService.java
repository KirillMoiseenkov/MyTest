package com.company.mytest.service;


import com.company.mytest.entity.City;

public interface CityService {
    String NAME = "mytest_CityService";

    City getDefaultCity();

}