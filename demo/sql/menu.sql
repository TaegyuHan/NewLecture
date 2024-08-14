create table MENU
(
    ID            NUMBER,
    KOR_NAME      NVARCHAR2(500),
    ENG_NAME      VARCHAR2(500),
    PRICE         NUMBER,
    IMG           VARCHAR2(200),
    REG_DATE      TIMESTAMP(6),
    CATEGORY_ID   NUMBER,
    REG_MEMBER_ID NUMBER
);