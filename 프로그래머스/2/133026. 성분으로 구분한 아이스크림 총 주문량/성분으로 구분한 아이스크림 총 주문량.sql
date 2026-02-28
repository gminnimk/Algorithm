-- FIRST_HALF: 아이스크림 가계의 상반기 주문 정보를 담은 테이블
-- ICECREAM_INFO: 아이스크림 성분에 대한 정보를 담은 테이블

-- 상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량이
-- 작은 순서대로 조회 (=> ORDER BY ASC)하는 SQL?

-- 총주문량을 나타내는 컬럼명은 TOTAL_ORDER => AS

SELECT
    II.INGREDIENT_TYPE,
    SUM(FH.TOTAL_ORDER) AS TOTAL_ORDER
FROM
    FIRST_HALF AS FH
JOIN
    ICECREAM_INFO AS II
ON
    FH.FLAVOR = II.FLAVOR -- 각 테이블의 기본 키
GROUP BY
    II.INGREDIENT_TYPE
ORDER BY
    TOTAL_ORDER ASC;