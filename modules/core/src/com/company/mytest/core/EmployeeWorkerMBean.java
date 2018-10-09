package com.company.mytest.core;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(description = "Performs operations on Employer")
public interface EmployeeWorkerMBean {

    @ManagedOperation(description = "say gaf")
    void sendGreetings();

    @ManagedOperation(description = "setFromAdress")
    void setFromAdress(String adress);

    @ManagedOperation(description = "getFromAdress")
    String getFromAdress();

}


