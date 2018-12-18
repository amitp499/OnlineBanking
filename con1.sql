create table CUSTOMER_DETAILS_TBL (
        CUSTOMERDETAIL_ID number(10) primary key,
        CUSTOMER_FULLNAME varchar2(30) not null,      
        ROLE varchar2(10) not null,
        CUSTOMER_PASSWORD varchar2(50) not null
        );

create table CUSTOMER_MASTER_TBL (
        CUSTMER_ID number(10) primary key,
        CUSTMER_NAME varchar2(30) not null,
        CUSTMER_MOBLILENO number(10) unique,        
        CUSTMER_GENDER varchar2(10) not null,
        CUSTMER_EMAIL varchar2(50) not null,
        CUSTMER_DATEOFBIRTH date not null,
        CUSTMER_CITY varchar2(30) not null,
        CUSTMER_ADDRESS varchar2(30) not null,
        CUSTMER_STATE varchar2(30) not null,
        CUSTMER_COUNTRY varchar2(30) not null,
        CUSTMER_BRANCH varchar2(30) not null,
        CUSTMER_AADHARID number(20) unique,
        CUSTMER_PANCARD varchar2(20) unique,
        CUSTOMER_PHOTO_PATH varchar2(30) not null,
        CUSTOMER_SIGNATURE_PATH varchar2(30) not null,
        CUSTOMERDETAIL_ID  number(10),
        foreign key(CUSTOMERDETAIL_ID) REFERENCES CUSTOMER_DETAILS_TBL(CUSTOMERDETAIL_ID)
        );
        COMMIT;
        
        
        
        drop table CUSTOMER_MASTER_TBL;
        drop table CUSTOMER_DETAILS_TBL;
        COMMIT;
        
        insert into CUSTOMER_MASTER_TBL values (987546,'Amit', 8082555499, 
        'male','amitp@gmail.com','17-Sep-1987','Thane', 'LM', 'MH','IN','Andheri', 98547, 653254, 'jkhjvjvbv', 'jkhvhj');
        commit;
        
        select * from CUSTOMER_MASTER_TBL;
        select * from CUSTOMER_DETAILS_TBL;
        desc CUSTOMER_MASTER_TBL;
        
        drop table CUSTOMER_DETAILS_TBL;
        
        commit;
        
        select * from CUSTOMER_DETAILS_TBL;
        
        insert into CUSTOMER_DETAILS_TBL values(9817547, 'Ait', 'cust', 'abcd');
        commit;
        
        delete from CUSTOMER_DETAILS_TBL where CUSTMER_ID=9817548;
        commit;
        delete from CUSTOMER_MASTER_TBL where CUSTMER_ID=9817547
        
        
         create table CUSTOMER_MASTER_TBL (
        USER_ID number(10) primary key,              
        ROLE varchar2(10) not null,
        CUSTOMER_PASSWORD varchar2(50) not null,
        CUSTOMER_ID number(10),
        foreign key(CUSTOMER_ID) REFERENCES CUSTOMER_DETAILS_TBL(CUSTOMER_ID)
        );

create table CUSTOMER_DETAILS_TBL (
        CUSTOMER_ID number(10) primary key,
        CUSTOMER_NAME varchar2(30) not null,
        CUSTOMER_MOBLILENO number(10) unique,        
        CUSTOMER_GENDER varchar2(10) not null,
        CUSTOMER_EMAIL varchar2(50) not null,
        CUSTOMER_DATEOFBIRTH date not null,
        CUSTOMER_CITY varchar2(30) not null,
        CUSTOMER_ADDRESS varchar2(30) not null,
        CUSTOMER_STATE varchar2(30) not null,
        CUSTOMER_COUNTRY varchar2(30) not null,
        CUSTOMER_BRANCH varchar2(30) not null,
        CUSTOMER_AADHARID number(20) unique,
        CUSTOMER_PANCARD varchar2(20) unique,
        CUSTOMER_PHOTO_PATH varchar2(30) not null,
        CUSTOMER_SIGNATURE_PATH varchar2(30) not null        
        );
        COMMIT;
        
        create table ACCOUNTS_TBL (
        USER_ID number(10) primary key,              
        ACCOUNT_TYPE varchar2(10) not null,
        ACCOUNT_BALANCE  number(12,2),
        ACCOUNT_ID number(10),
        foreign key(USER_ID) REFERENCES CUSTOMER_MASTER_TBL(USER_ID)
        );
        commit;
   
        
        


