alter table MYTEST_MESSAGE add constraint FK_MYTEST_MESSAGE_QUESTION foreign key (QUESTION_ID) references MYTEST_QUESTION(ID);
create index IDX_MYTEST_MESSAGE_QUESTION on MYTEST_MESSAGE (QUESTION_ID);