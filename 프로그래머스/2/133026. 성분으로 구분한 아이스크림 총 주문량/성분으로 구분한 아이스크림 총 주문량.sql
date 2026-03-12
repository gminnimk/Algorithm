-- FIRST_HALF: 아이스크림 가게의 상반기 주문 정보 테이블
-- ICECREAM_INFO: 아이스크림 성분에 대한 정보 테이블

-- 상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총 주문량을
-- 총주문량이 적은 순서대로 조회하는 SQL 문을 작성.
-- 컬럼명은 TOTAL_ORDER

SELECT
    II.INGREDIENT_TYPE,
    SUM(FH.TOTAL_ORDER) AS TOTAL_ORDER
FROM
    FIRST_HALF AS FH
JOIN
    ICECREAM_INFO AS II
ON
    FH.FLAVOR = II.FLAVOR
GROUP BY
    II.INGREDIENT_TYPE
-- 총주문량이 적은 순서대로
ORDER BY
    TOTAL_ORDER;
        