package com.company.mytest.web.city;

import com.company.mytest.service.CityService;
import com.haulmont.cuba.core.app.DataService;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.mytest.entity.City;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.List;

public class CityEdit extends AbstractEditor<City> {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CityEdit.class);

    @Inject
    CityService cityService;

    @Inject
    DataManager dataManager;

    @Override
    protected boolean postCommit(boolean committed, boolean close) {

      /*  City city = getItem();

        LoadContext loadContext = LoadContext.create(City.class)
                .setQuery(LoadContext.createQuery
                        ("select e from mytest$City e WHERE e.defaultCity = TRUE and e.id <> :id")
                                .setParameter("id",city.getId()));


       List<City> cityList = dataManager.loadList(loadContext);

       cityList.forEach(city1 -> city1.setDefaultCity(false));

       CommitContext commitContext = new CommitContext(cityList);

       dataManager.commit(commitContext);*/

        return super.postCommit(committed, close);
    }


}