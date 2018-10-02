alter table MYTEST_REPAIR_EMPLOYEE_LINK add constraint FK_REPEMP_REPAIR foreign key (REPAIR_ID) references MYTEST_REPAIR(ID);
alter table MYTEST_REPAIR_EMPLOYEE_LINK add constraint FK_REPEMP_EMPLOYEE foreign key (EMPLOYEE_ID) references MYTEST_EMPLOYEE(ID);
