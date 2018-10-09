package com.company.mytest.core;

import com.company.mytest.core.config.EmailConfig;
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

    @Override
    @Authenticated
    public void sendGreetings() {



        EmailInfo emailInfo = new EmailInfo("moiseenkov@haulmont.com", "caption", "body");

        emailService.sendEmailAsync(emailInfo);

        Integer integer = scripting.evaluateGroovy("2+9", new Binding());

        System.out.println(integer);
    }


    @Override
    @Authenticated
    public void setFromAdress(String adress)
    {
        emailConfig.setExFromAddress(adress);
    }

    @Override
    @Authenticated
    public String getFromAdress() {
        return emailConfig.getExFromAddress();
    }
}
