# [ 문제 ]

-- - FOOD_PRODUCT: 식품의 정보를 담은 테이블 (PK: PRODUCT_ID)
-- - FODD_ORDER: 식품의 주문 정보를 담은 테이블 (PK: ORDER_ID, FK: PRODUCT_ID)

-- - FOOD_PRODUCT와 FOOD_ORDER 테이블에서 생산일자가 2022년 5월인 식품들의 식품 ID, 식품 이름, 총매출을 조회하는 SQL문을 작성해주세요. 이때 결과는 총매출을 기준으로 내림차순 정렬해주시고 총매출이 같다면 식품 ID를 기준으로 오름차순 정렬해주세요.


# [ 메모리 멘탈 모델 ]

-- - 1. 두 테이블을 PRODUCT_ID 기준으로 이너조인한다.
-- - 2. WHERE 필터에서 생산일자(PRODUCE_DATE) 를 기준으로 필터링한다.
-- - 3. ID, 이름, 총매출(TOTAL_SALES) => SUM 집계 함수
-- - 4. 정렬 구체화.


SELECT P.PRODUCT_ID,
       P.PRODUCT_NAME,
       (P.PRICE * SUM(O.AMOUNT)) AS TOTAL_SALES
FROM FOOD_PRODUCT AS P
INNER JOIN FOOD_ORDER AS O ON P.PRODUCT_ID = O.PRODUCT_ID
WHERE O.PRODUCE_DATE LIKE '2022-05%'
GROUP BY P.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, P.PRODUCT_ID ASC;