package com.company.mytest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@NamePattern("%s|name")
@Table(name = "MYTEST_CAR_SERVICE_CENTER")
@Entity(name = "mytest$CarServiceCenter")
public class CarServiceCenter extends StandardEntity {
    private static final long serialVersionUID = 7441713936957980502L;

    @Column(name = "NAME")
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    protected City city;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "center")
    protected List<Repair> repair;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "center")
    protected List<Employee> employee;

    @Column(name = "PHONE")
    protected String phone;

    @Column(name = "ADRESS")
    protected String adress;

    @JoinTable(name = "MYTEST_CAR_SERVICE_CENTER_CUSTOMER_LINK",
        joinColumns = @JoinColumn(name = "CAR_SERVICE_CENTER_ID"),
        inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID"))
    @ManyToMany
    protected List<Customer> customer;

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }


    public void setRepair(List<Repair> repair) {
        this.repair = repair;
    }

    public List<Repair> getRepair() {
        return repair;
    }


    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployee() {
        return employee;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomer() {
        return customer;
    }


}