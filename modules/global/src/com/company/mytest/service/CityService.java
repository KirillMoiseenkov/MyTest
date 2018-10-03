package com.company.mytest.service;


import com.company.mytest.entity.City;

import java.util.UUID;

public interface CityService {
    String NAME = "mytest_CityService";

    City getDefaultCity();

    void resetDefaultCity(UUID id);
}