package com.company.mytest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@Table(name = "MYTEST_COMPANY")
@Entity(name = "mytest$Company")
public class Company extends Customer {
    private static final long serialVersionUID = -7597345577493421391L;

    @NotNull
    @Column(name = "INN", nullable = false)
    protected Integer inn;

    public void setInn(Integer inn) {
        this.inn = inn;
    }

    public Integer getInn() {
        return inn;
    }


}