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
-- begin MYTEST_CAR_SERVICE_CENTER
create table MYTEST_CAR_SERVICE_CENTER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    CITY_ID varchar(36),
    PHONE varchar(255),
    ADRESS varchar(255),
    --
    primary key (ID)
)^
-- end MYTEST_CAR_SERVICE_CENTER
-- begin MYTEST_EMPLOYEE
create table MYTEST_EMPLOYEE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255),
    BITH_DATE date not null,
    EMAIL varchar(255),
    SALARY integer not null,
    CENTER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end MYTEST_EMPLOYEE
-- begin MYTEST_REPAIR
create table MYTEST_REPAIR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DESCRIPTION varchar(255) not null,
    CENTER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end MYTEST_REPAIR
-- begin MYTEST_CAR_SERVICE_CENTER_CUSTOMER_LINK
create table MYTEST_CAR_SERVICE_CENTER_CUSTOMER_LINK (
    CAR_SERVICE_CENTER_ID varchar(36) not null,
    CUSTOMER_ID varchar(36) not null,
    primary key (CAR_SERVICE_CENTER_ID, CUSTOMER_ID)
)^
-- end MYTEST_CAR_SERVICE_CENTER_CUSTOMER_LINK
-- begin MYTEST_REPAIR_EMPLOYEE_LINK
create table MYTEST_REPAIR_EMPLOYEE_LINK (
    REPAIR_ID varchar(36) not null,
    EMPLOYEE_ID varchar(36) not null,
    primary key (REPAIR_ID, EMPLOYEE_ID)
)^
-- end MYTEST_REPAIR_EMPLOYEE_LINK
-- begin MYTEST_CITY
create table MYTEST_CITY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DEFAULT_CITY boolean,
    CODE integer not null,
    --
    primary key (ID)
)^
-- end MYTEST_CITY
