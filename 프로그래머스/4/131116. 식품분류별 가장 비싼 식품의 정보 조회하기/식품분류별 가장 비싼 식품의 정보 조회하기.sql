-- [문제]
-- FOOD_PRODUCT: 식품의 정보를 담은 테이블

-- FOOD_PRODUCT 테이블에서 식품분류별로 가격이 제일 비싼 식품의 분류, 가격, 이름을 조회하는 SQL문을 작성.
-- '식품분류(CATEGORY)별 가격이 제일 비싼' => GROUP BY & HAVING MAX? 

-- 이때 식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력시켜 주시고 결과는 식품 가격을 기준으로 내림차순 정렬.
-- '식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력' => HAVING
-- '식품 가격을 기준으로 내림차순 정렬' => ORDER BY PRICE DESC;

-- [풀이]
SELECT
    CATEGORY,
    PRICE AS MAX_PRICE,
    PRODUCT_NAME
FROM (
    SELECT
        CATEGORY,
        PRICE,
        PRODUCT_NAME,
        RANK() OVER (PARTITION BY CATEGORY ORDER BY PRICE DESC) as rnk
    FROM
        FOOD_PRODUCT
    WHERE
        CATEGORY IN ('과자', '국', '김치', '식용유')
) AS T
WHERE rnk = 1
ORDER BY PRICE DESC;
