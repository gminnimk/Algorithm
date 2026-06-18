-- 코드를 입력하세요
SELECT
    FP.CATEGORY,
    FP.PRICE AS MAX_PRICE,
    FP.PRODUCT_NAME
FROM
    FOOD_PRODUCT AS FP -- 식품의 정보
-- 식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력
WHERE (CATEGORY, PRICE) IN (
    SELECT CATEGORY, MAX(PRICE)
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
    GROUP BY CATEGORY
)
ORDER BY
    FP.PRICE DESC;