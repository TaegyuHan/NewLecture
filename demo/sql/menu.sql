CREATE TABLE MENU
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

-- INNER JOIN 예시
SELECT
    M.*,
    C.NAME AS CATEGORY_NAME,
    MI.SRC AS IMG
FROM MENU M
    LEFT JOIN (SELECT * FROM MENU_IMAGE WHERE DEFAULT_IMG = 1) MI
    ON M.ID = MI.MENU_ID
JOIN CATEGORY C
    ON M.CATEGORY_ID = C.ID;

-- INNER JOIN 예시
SELECT *
FROM MENU
INNER JOIN (
    SELECT *
    FROM MENU_IMAGE
    WHERE DEFAULT_IMG = 1
) MI
ON MENU.ID = MI.MENU_ID;

-- VIEW 실행
SELECT * FROM MENU_VIEW;

-- 1. 형태소 분석
-- 2. 구문 분석
-- 3. 실행계획
-- 4. 번역 (컴파일) < 뷰는 여기부터 실행
-- 5. 실행

-- 시퀀스 생성하고 아이디 값을 지정하자


-- 시퀀스
CREATE SEQUENCE MENU_SEQ_TEST;
SELECT MENU_ID_SEQUENCE.NEXTVAL FROM DUAL;

INSERT INTO MENU (ID, KOR_NAME, ENG_NAME, PRICE, IMG, REG_DATE, CATEGORY_ID, REG_MEMBER_ID)
VALUES (MENU_SEQ_TEST.NEXTVAL, '테스트', 'TEST', 1000, 'test.jpg', SYSDATE, 1, 1);

-- 셀프 조인

SELECT * FROM MEMBER;

SELECT
    M.*,
    MR.NICKNAME AS RCMD_MEMBER_NICKNAME
FROM (SELECT * FROM MEMBER WHERE ID = 5) M
LEFT JOIN MEMBER MR
ON M.RCMD_MEMBER_ID = MR.ID;

-- 크로스 조인
-- 절대 하지 말아라!!!

-- 정렬
SELECT *
FROM MENU
ORDER BY REG_DATE DESC;

-- 함수가 존재 한다.
-- 서브 쿼리 버전
SELECT
    M.ID,
    M.KOR_NAME,
    M.PRICE,
    NVL(MI.IMG_COUNT, 0) AS IMG_COUNT,
    NVL(ML.LIKE_COUNT, 0) AS LIKE_COUNT
FROM MENU M
LEFT JOIN ( -- 이미지 수 카운트
    SELECT
        S_MI.MENU_ID AS S_MI_ID,
        COUNT(S_MI.ID) AS IMG_COUNT
    FROM MENU_IMAGE S_MI
    GROUP BY MENU_ID
) MI
ON M.ID = MI.S_MI_ID
LEFT JOIN ( -- 좋아요 수 카운트
    SELECT
        S_ML.MENU_ID AS S_MI_ID,
        COUNT(S_ML.MENU_ID) AS LIKE_COUNT
    FROM MENU_LIKE S_ML
    GROUP BY MENU_ID
) ML
ON M.ID = ML.S_MI_ID;

-- 서브 퀀리 X 버전
SELECT
    M.ID,
    M.KOR_NAME,
    M.PRICE,
    M.REG_DATE,
    M.REG_MEMBER_ID,
    M.CATEGORY_ID,
    COUNT(MI.ID) AS IMG_COUNT
FROM MENU M
LEFT JOIN MENU_IMAGE MI
ON M.ID = MI.MENU_ID
GROUP BY
    M.ID,
    M.KOR_NAME,
    M.PRICE,
    M.REG_DATE,
    M.REG_MEMBER_ID,
    M.CATEGORY_ID;

-- 컬럼 버전
-- 특정 상황에서만 좋다. > 개수가 적은 것을 기준으로 탐색할 떄
SELECT
    MENU.*,
    -- 해쉬드 머쥐가 일어난다.
    (SELECT COUNT(ID) FROM MENU_IMAGE WHERE MENU_ID = MENU.ID) AS IMG_COUNT
FROM MENU; -- 6조 픽

-- 코드 가독성의 난이도가 낮은가?
-- 실행 성능이 어떤게 좋은가?

-- 인덱스가 있느냐?
-- 레코드가 어디가 많은가?

-- 몇개의 갯수를 찾고 탐색하는 것과
-- 모든 개수를 탐색하는 것의 차이

-- 나중에 튜닝을 위한 공부를 하는게 좋다.

SELECT
    M.ID,
    M.KOR_NAME,
    M.PRICE,
    M.REG_DATE,
    M.REG_MEMBER_ID,
    M.CATEGORY_ID,
    COUNT(ML.MENU_ID) AS LIKE_COUNT
FROM MENU M
LEFT JOIN MENU_LIKE ML
    ON M.ID = ML.MENU_ID
GROUP BY M.ID, M.KOR_NAME, M.PRICE, M.REG_DATE, M.REG_MEMBER_ID, M.CATEGORY_ID;


-- 강사님 코드
SELECT M.*,
       MI.SRC IMG,
       NVL(ML.LIKE_COUNT, 0) AS LIKE_COUNT
FROM MENU M
         LEFT JOIN (SELECT * FROM MENU_IMAGE WHERE DEFAULT_IMG = 1) MI
                   ON M.ID = MI.MENU_ID
         LEFT JOIN (SELECT MENU_ID, COUNT(MENU_ID) LIKE_COUNT FROM MENU_LIKE GROUP BY MENU_ID) ML
                   ON M.ID = ML.MENU_ID;

-- 유니온 정리
SELECT *
FROM (
    SELECT KOR_NAME AS TITLE FROM MENU
    UNION -- 집합
    -- UNION ALL -- 중복을 제거하지 않는다.
    -- MINUS -- 차집합
    -- INTERSECT -- 교집합
    SELECT TITLE AS TITLE FROM NOTICE
)
WHERE TITLE LIKE '%아%';