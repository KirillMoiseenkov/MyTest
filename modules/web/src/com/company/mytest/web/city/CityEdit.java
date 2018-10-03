package com.company.mytest.web.city;

import com.company.mytest.service.CityService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.mytest.entity.City;

import javax.inject.Inject;

public class CityEdit extends AbstractEditor<City> {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CityEdit.class);

    @Inject
    CityService cityService;

    @Override
    protected boolean postCommit(boolean committed, boolean close) {

        City city = getItem();

        if (committed && city.getDefaultCity()) {
            cityService.resetDefaultCity(city.getId());
        }

        return super.postCommit(committed, close);
    }
}