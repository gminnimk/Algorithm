# [ 문제 ]

-- - FOOD_ORDER: 식품공장의 주문정보 테이블

-- - FOOD_ORDER 테이블에서 2022년 5월 1일을 기준으로 주문 ID, 제품 ID, 출고일자, 출고여부를 조회하는 SQL문을 작성해주세요. 출고여부는 2022년 5월 1일까지 출고완료로 이 후 날짜는 출고 대기로 미정이면 출고미정으로 출력해주시고, 결과는 주문 ID를 기준으로 오름차순 정렬해주세요.

-- - CASE WHEN THEN ELSE END 문이 필요할 것으로 예상되고
-- - (1). OUT_DATE 가 5월 1일까지는 '출고완료'
-- - (1). OUT_DATE 가 5월 1일 이후로는 '출고대기'
-- - (1). OUT_DATE 가 없으면 '출고미정'


# [ 메모리 멘탈 모델 ]

-- - 1. FOOD_ORDER 테이블을 가져와서 SELECT 절에 추출 컬럼을 명시
-- - 2. 출고일자에 따른 출고여부를 CASE WHEN THEN ELSE END 문으로 처리한다.
-- - 3. 정렬 처리

SELECT O.ORDER_ID,
       O.PRODUCT_ID,
       O.OUT_DATE,
       CASE
           WHEN O.OUT_DATE <= '2022-05-01' THEN '출고완료'
           WHEN O.OUT_DATE > '2022-05-01' THEN '출고대기'
           ELSE '출고미정'
       END AS '출고여부'
FROM FOOD_ORDER AS O
ORDER BY O.ORDER_ID ASC;