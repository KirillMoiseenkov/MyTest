package com.company.mytest.web.carservicecenter;

import com.company.mytest.entity.City;
import com.company.mytest.entity.Customer;
import com.company.mytest.service.CityService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.*;
import com.company.mytest.entity.CarServiceCenter;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.*;

public class CarServiceCenterEdit extends AbstractEditor<CarServiceCenter> {

    @Inject
    CityService cityService;

    @Inject
    private CollectionDatasource<Customer, UUID> customersDs;

    @Inject
    TabSheet editTabSheet;

    @Inject
    protected Table customerTable;


    @Override
    public void init(Map<String, Object> params) {
        super.init(params);


        customerTable.addGeneratedColumn("TypeOfCustomer", new Table.ColumnGenerator() {
            @Override
            public Component generateCell(Entity entity) {

                return new Table.PlainTextCell(entity.getClass().getSimpleName());
            }
        });

        customersDs.addCollectionChangeListener(e -> {

            Collection<Customer> customerList = customersDs.getItems();
            TabSheet.Tab tab = editTabSheet.getTab("customerTab");

            if (customerList.size() != 0) {
                tab.setCaption("Customer(" + customerList.size() + ")");
            } else
                tab.setCaption("Customer");

        });

    }

    @Override
    protected void initNewItem(CarServiceCenter item) {

        item.setCity(cityService.getDefaultCity());
    }
}