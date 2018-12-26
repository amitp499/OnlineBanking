
        
        --new
        
        Create sequence customer_id_seq;
        create sequence login_id_seq;
        create sequence account_no_seq;
        create sequence beneficiary_id_seq;
        create sequence transaction_id_seq start with 268887;
        commit;
        
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
    
        
     create table CUSTOMER_MASTER_TBL (
        LOGIN_ID number(10) primary key,              
        ROLE varchar2(10) not null,
        CUSTOMER_PASSWORD varchar2(50) not null,
        CUSTOMER_ID number(10) not null,
        foreign key(CUSTOMER_ID) REFERENCES CUSTOMER_DETAILS_TBL(CUSTOMER_ID)
        );
        commit;

	    
        create table ACCOUNTS_TBL (
        CUSTOMER_ID number(10) ,              
        ACCOUNT_TYPE varchar2(10) not null,
        ACCOUNT_BALANCE  number(12,2),
        ACCOUNT_No number(10) primary key,
        foreign key(CUSTOMER_ID) REFERENCES CUSTOMER_DETAILS_TBL(CUSTOMER_ID)
        );
        commit;
        
        
        create table BENEFICIARY_DETAILS_TBL (
        CUSTOMER_ID number(10) ,              
        BENEFICIARY_IFSC_CODE varchar2(10) unique,
        BENEFICIARY_ACCOUNTNO number(10) not null,
        BENEFICIARY_NAME varchar2(30) not null,
        BENEFICIARY_ID number(10) primary key,
        foreign key(CUSTOMER_ID) REFERENCES CUSTOMER_DETAILS_TBL(CUSTOMER_ID)
        );
        commit;
        
        create table TRANSACTION_TBL (
        CUSTOMER_ACCOUNT_NO number(10) ,              
        TRANSACTION_TYPE varchar2(10) not null,
        BENE_ACCOUNTNO number(10) not null,
        ACCOUNT_BALANCE  number(12,2) not null,
        AMOUNT  number(12,2) not null,
        TRANSACTION_ID number(20) primary key,
        TRANSACTION_DATETIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        TRANSACTION_INFO varchar2(30) not null,
        foreign key(CUSTOMER_ACCOUNT_NO) REFERENCES ACCOUNTS_TBL(ACCOUNT_No)
        );
        commit;
        
        
        select * from CUSTOMER_MASTER_TBL;
        desc CUSTOMER_MASTER_TBL;
        desc CUSTOMER_DETAILS_TBL;
        select * from CUSTOMER_DETAILS_TBL;
        select * from ACCOUNTS_TBL;
        select * from BENEFICIARY_DETAILS_TBL;
        select * from TRANSACTION_TBL;
        desc TRANSACTION_TBL;
        
        drop table CUSTOMER_DETAILS_TBL;
        drop table CUSTOMER_MASTER_TBL;
        drop table ACCOUNTS_TBL;
        drop table TRANSACTION_TBL;
        drop table BENEFICIARY_DETAILS_TBL;
        commit;
        
        select beneficiary_id_seq.nextval from dual
    
        
   
   
        
        


