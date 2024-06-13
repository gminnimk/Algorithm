SELECT SUBSTR(PRODUCT_CODE,1,2) AS CATEGORY, -- 상품코드에서 1에서 2번째 자릿수까지 추출 및 CATEGORY로 표기
       COUNT(1) AS PRODUCTS -- 전체 갯수 조회를 PRODUCTS로 표기 
FROM PRODUCT -- PRODUCT 테이블에서 
GROUP BY SUBSTR(PRODUCT_CODE, 1, 2) -- 상품코드 1~2번째 자리까지 기준 값 별로 그룹지정
ORDER BY PRODUCT_CODE ASC -- 상품코드로 오름차순 정렬 