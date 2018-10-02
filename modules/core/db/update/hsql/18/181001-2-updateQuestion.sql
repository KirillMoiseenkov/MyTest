alter table MYTEST_QUESTION add column AUTHOR varchar(255) ^
update MYTEST_QUESTION set AUTHOR = '' where AUTHOR is null ;
alter table MYTEST_QUESTION alter column AUTHOR set not null ;
