-- 문제
-- FOOD_PRODUCT와 FOOD_ORDER 테이블에서 생산일자가 2022년 5월인 식품들의 식품 ID, 식품 이름, 총매출을 조회하는 SQL문을 작성해주세요.

-- FOOD_PRODUCT: 식품의 정보를 담은 테이블
-- FOOD_ORDER: 식품의 주문 정보를 담은 테이블

-- 두 테이블에서
-- (1). 생산일자가 2022년 5월이여야 함 (생산일자는 FOOD_ORDER 테이블)
-- (2). 총매출을 구해야함 (총매출은 식품 ID로 집계 후 SUM(P.PRICE * O.AMOUNT))
-- => 두 테이블을 INNER JOIN (주문 데이터가 있는 데이터만 출력해야 하므로)

SELECT P.PRODUCT_ID,    -- 식품 ID
       P.PRODUCT_NAME,  -- 식품 이름
       SUM(P.PRICE * O.AMOUNT) AS TOTAL_SALES   -- 총매출
FROM FOOD_PRODUCT AS P
JOIN FOOD_ORDER AS O
ON P.PRODUCT_ID = O.PRODUCT_ID

-- 생산일자가 2022년 5월인 식품 => ~ >= AND < ~ 사용
WHERE O.PRODUCE_DATE >= '2022-05-01' AND O.PRODUCE_DATE < '2022-06-01'
GROUP BY P.PRODUCT_ID
         
-- 총매출을 기준으로 내림차순 정렬
-- 총매출이 같다면 식품 ID를 기준으로 오름차순 정렬
ORDER BY TOTAL_SALES DESC,
         P.PRODUCT_ID ASC;