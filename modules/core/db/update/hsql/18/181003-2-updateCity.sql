update MYTEST_CITY set DEFAULT_CITY = false where DEFAULT_CITY is null ;
alter table MYTEST_CITY alter column DEFAULT_CITY set not null ;
