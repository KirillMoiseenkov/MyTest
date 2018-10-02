package com.company.mytest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Column;

@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@Table(name = "MYTEST_INDIVIDUAL")
@Entity(name = "mytest$Individual")
public class Individual extends Customer {
    private static final long serialVersionUID = 4832141586843743006L;

    @Column(name = "PASSPORT_NO", nullable = false)
    protected Integer passportNo;

    public void setPassportNo(Integer passportNo) {
        this.passportNo = passportNo;
    }

    public Integer getPassportNo() {
        return passportNo;
    }


}