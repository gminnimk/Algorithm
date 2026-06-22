-- 문제: 
-- 상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량을 총주문량이 작은 순서대로 조회하는 SQL 문을 작성.
-- II.INGREDITENT_TYPE / TOTAL_ORDER / ASC

-- 아이스크림 가게의 상반기 주문 정보를 담은 테이블: FIRST_HALF
-- FLAVOR(PK)

-- 아이스크림 성분에 대한 정보를 담은 테이블: ICECREAM_INFO
-- FLAVOR(PK)

-- LEFT JOIN (ICECREAM_INFO) => GROUP BY 성분 타입 => SUM 함수(TOTAL_ORDER)


SELECT
    II.INGREDIENT_TYPE,
    SUM(TOTAL_ORDER) AS TOTAL_ORDER
FROM
    FIRST_HALF AS FH
LEFT JOIN
    ICECREAM_INFO AS II ON FH.FLAVOR = II.FLAVOR
GROUP BY
    II.INGREDIENT_TYPE
ORDER BY
    TOTAL_ORDER;