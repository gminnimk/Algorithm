SELECT PRODUCT_ID, -- 식품 ID 컬럼 가져오기
       PRODUCT_NAME, -- 식품 이름 컬럼 가져오기
       PRODUCT_CD, -- 식품 코드 컬럼 가져오기
       CATEGORY, -- 식품분류 컬럼 가져오기
       PRICE -- 식품 가격 컬럼 가져오기
FROM FOOD_PRODUCT -- FOOD_PRODUCT 테이블에서 
WHERE PRICE = (SELECT MAX(PRICE) FROM FOOD_PRODUCT) -- SUB 쿼리문을 사용해서 WHERE 절 완성