CREATE TABLE NOTICE246
(
    ID            NUMBER,
    TITLE         NVARCHAR2(500),
    CONTENT       NVARCHAR2(2000),
    HIT_COUNT     NUMBER,
    REG_MEMBER_ID NUMBER,
    REG_DATE      TIMESTAMP
);

-- ALTER TABLE NOTICE246 MODIFY CONTENT CLOB;
-- ALTER TABLE NOTICE246 ADD UPDATE_DATE TIMESTAMP;

CREATE TABLE MEMBER246
(
    ID        NUMBER,
    USER_NAME VARCHAR2(100),
    PWD       VARCHAR2(100),
    PHONE     CHAR(11),
    EMAIL     VARCHAR2(100),
    ADDRESS   NVARCHAR2(200),
    REG_DATE  TIMESTAMP
);

SELECT *
FROM NLS_DATABASE_PARAMETERS;
-- DROP TABLE NOTICE246;


SELECT ID, TITLE
FROM NOTICE;

SELECT *
FROM NOTICE;

INSERT INTO MEMBER (ID, USERNAME, PWD, PHONE, EMAIL, ADDRESS, REG_DATE)
VALUES (246, 'TaegyuHan', 'asd123', '01012345678', 'eamil@gmail.com', '대한민국 어딘가', '2024-08-12 12:52:12');


SELECT *
FROM MEMBER
WHERE ID = 246;

DELETE MEMBER
WHERE ID = 246;

COMMIT;

UPDATE MEMBER
SET PWD='222'
WHERE USERNAME = 'TaegyuHan';


SELECT *
FROM MEMBER
WHERE USERNAME = 'TaegyuHan';

SELECT *
FROM MEMBER
WHERE ID = 168;


SELECT ID       AS USER_ID,
       USERNAME AS NAME,
       PWD      AS PASSWORD
FROM MEMBER;


SELECT 2147483647 + 1
FROM DUAL;

SELECT 9223372036854775807 + 1
FROM DUAL;

SELECT CONCAT('3', 10)
FROM DUAL;


SELECT '3' || 10 || 10
FROM DUAL;


UPDATE MEMBER
SET USERNAME='HACK'
WHERE USERNAME IN ('한태규 입니다.', '저는 한태규 입니다.', '저는 한태규 일까요???????.', '한태규%', 'zI존전사한태규.',
                   '한태규 239842309489230겾ㄷ갸ㅕㅓㅐㅑ%^&93284@*34ㅕ7598ㄱ', '한태규');
COMMIT;

SELECT *
FROM MEMBER;

DELETE
FROM MEMBER
WHERE USERNAME = 'HACK';

SELECT MEMBER.*,
       USERNAME || '(' || ID || ')' AS "이름"
FROM MEMBER;


insert into MEMBER (ID, USERNAME, PWD, PHONE, EMAIL, ADDRESS, REG_DATE)
values (2399, 'hack', '1234', '01012345678', 'eamil@gmail.com', '대한민국 어딘가', '2024-08-12 12:52:12');

commit;


SELECT *
FROM MEMBER
WHERE EMAIL IS NULL;


SELECT *
FROM MEMBER
WHERE EMAIL IS NOT NULL;

SELECT *
FROM NOTICE
WHERE HIT_COUNT BETWEEN 1 AND 10
ORDER BY HIT_COUNT DESC;

SELECT *
FROM NOTICE
WHERE HIT_COUNT IN (2, 5, 7, 9);


SELECT *
FROM NOTICE
WHERE HIT_COUNT NOT IN (2, 5, 7, 10);

SELECT *
FROM MEMBER
WHERE USERNAME LIKE '%이%';



SELECT *
FROM NOTICE;