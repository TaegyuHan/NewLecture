CREATE TABLE NOTICE246(
                          ID              NUMBER,
                          TITLE           NVARCHAR2(500),
                          CONTENT         NVARCHAR2(2000),
                          HIT_COUNT       NUMBER,
                          REG_MEMBER_ID   NUMBER,
                          REG_DATE        TIMESTAMP
);

-- ALTER TABLE NOTICE246 MODIFY CONTENT CLOB;
-- ALTER TABLE NOTICE246 ADD UPDATE_DATE TIMESTAMP;

CREATE TABLE MEMBER246(
                          ID              NUMBER,
                          USER_NAME       VARCHAR2(100),
                          PWD             VARCHAR2(100),
                          PHONE           CHAR(11),
                          EMAIL           VARCHAR2(100),
                          ADDRESS         NVARCHAR2(200),
                          REG_DATE        TIMESTAMP
);

SELECT * FROM NLS_DATABASE_PARAMETERS;
-- DROP TABLE NOTICE246;





SELECT ID, TITLE FROM NOTICE;

SELECT * FROM NOTICE;

insert into MEMBER (ID, USERNAME, PWD, PHONE, EMAIL, ADDRESS, REG_DATE)
values (246, 'TaegyuHan', 'asd123', '01012345678', 'eamil@gmail.com', '대한민국 어딘가', '2024-08-12 12:52:12');


SELECT * FROM MEMBER WHERE ID=246;

DELETE MEMBER WHERE ID=246;

COMMIT;


