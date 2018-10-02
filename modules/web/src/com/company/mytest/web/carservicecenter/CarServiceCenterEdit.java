package com.company.mytest.web.carservicecenter;

import com.company.mytest.service.CityService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.mytest.entity.CarServiceCenter;
import com.haulmont.cuba.gui.data.Datasource;
import com.vaadin.external.org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.logging.Logger;

public class CarServiceCenterEdit extends AbstractEditor<CarServiceCenter> {

    @Inject
    CityService cityService;

    @Override
    protected void initNewItem(CarServiceCenter item) {

        cityService.getDefaultCity();
//        System.out.println(item.getAdress());
    //    item.setAdress(cityService.getDefaultCity().getName());

    }
}