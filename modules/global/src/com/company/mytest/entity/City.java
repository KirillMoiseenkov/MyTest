package com.company.mytest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.Listeners;

@Listeners("mytest_CityListener")
@NamePattern("%s|name")
@Table(name = "MYTEST_CITY")
@Entity(name = "mytest$City")
public class City extends StandardEntity {
    private static final long serialVersionUID = 6765023321627816915L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull(message = "false")
    @Column(name = "DEFAULT_CITY", nullable = false)
    protected Boolean defaultCity = false;

    @Column(name = "CODE", nullable = false)
    protected Integer code;

    public void setDefaultCity(Boolean defaultCity) {
        this.defaultCity = defaultCity;
    }

    public Boolean getDefaultCity() {
        return defaultCity;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }


}