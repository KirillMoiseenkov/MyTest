-- begin MYTEST_CUSTOMER
create table MYTEST_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    NAME varchar(255) not null,
    PHONE varchar(255) not null,
    EMAIL varchar(255) not null,
    --
    primary key (ID)
)^
-- end MYTEST_CUSTOMER
-- begin MYTEST_INDIVIDUAL
create table MYTEST_INDIVIDUAL (
    ID varchar(36) not null,
    --
    PASSPORT_NO integer not null,
    --
    primary key (ID)
)^
-- end MYTEST_INDIVIDUAL
-- begin MYTEST_COMPANY
create table MYTEST_COMPANY (
    ID varchar(36) not null,
    --
    INN integer not null,
    --
    primary key (ID)
)^
-- end MYTEST_COMPANY
