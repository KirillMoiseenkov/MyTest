package com.company.mytest.core;

import com.company.mytest.core.config.EmailConfig;
import com.company.mytest.service.CityService;
import com.company.mytest.service.EmployeeService;
import com.company.mytest.service.EmployeeServiceBean;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.core.global.Scripting;
import com.haulmont.cuba.security.app.Authenticated;
import groovy.lang.Binding;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component("mytest_EmployeeWorkerMBean")
public class EmployeeWorker implements EmployeeWorkerMBean {

    @Inject
    protected EmailService emailService;

    @Inject
    protected Scripting scripting;

    @Inject
    EmailConfig emailConfig;

    @Inject
    Persistence persistence;

    @Inject
    EmployeeService employeeService;

    @Override
    @Authenticated
    public void sendGreetings() {

        employeeService.updateEmploeeListByBirthDay();

        employeeService.castToListMap();

        employeeService.getDateList().forEach(components -> {

            Binding binding = new Binding();

            components.forEach(binding::setVariable);

            String body = scripting.runGroovyScript("bitdDayCongratulation.groovy", binding);

            EmailInfo emailInfo = new EmailInfo("moiseenkov@haulmont.com", "Happy BirthDAY", emailConfig.getExFromAddress(), body);

            emailService.sendEmailAsync(emailInfo);
        });
    }


    @Override
    @Authenticated
    public void setFromAdress(String adress) {
        emailConfig.setExFromAddress(adress);
    }

    @Override
    @Authenticated
    public String getFromAdress() {
        return emailConfig.getExFromAddress();
    }
}
