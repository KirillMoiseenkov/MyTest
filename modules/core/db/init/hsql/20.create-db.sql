-- begin MYTEST_INDIVIDUAL
alter table MYTEST_INDIVIDUAL add constraint FK_MYTEST_INDIVIDUAL_ID foreign key (ID) references MYTEST_CUSTOMER(ID)^
-- end MYTEST_INDIVIDUAL
-- begin MYTEST_COMPANY
alter table MYTEST_COMPANY add constraint FK_MYTEST_COMPANY_ID foreign key (ID) references MYTEST_CUSTOMER(ID)^
-- end MYTEST_COMPANY
