-- [문제]
-- FOOD_PRODUCT: 식품의 정보를 담은 테이블

-- FOOD_PRODUCT 테이블에서 식품분류별로 가격이 제일 비싼 식품의 분류, 가격, 이름을 조회하는 SQL문을 작성. 
-- '식품분류별' => GROUP BY CATEGORY

-- 문제에서 '식품의 분류, 가격, 이름' 을 출력해달라고 하였는데 GROUP BY CATEGORY 를 해서 SELECT MAX(PRICE) 를 한다고 했을때 CATEGORY와 MAX_PRICE 값은 기대 값이 나오겠지만 '이름' 은 어떤 값을 추출해야할지를 찾지 못 하는 오류가 나타날 수 있음

-- 따라서 1) 서브쿼리 or 2) 윈도우 함수 를 이용해서 답을 찾을 수 있도록 해야함


-- 이때 식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력시켜 주시고 결과는 식품 가격을 기준으로 내림차순 정렬.

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
        RANK() OVER(PARTITION BY CATEGORY ORDER BY PRICE DESC) AS rnk
    FROM
        FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
) AS T
WHERE rnk = 1
ORDER BY PRICE DESC;