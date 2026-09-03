# [ 문제 ]

-- - PRODUCT: 의류 쇼핑몰에서 판맨중인 상품들의 상품 점보를 담은 테이블 (PK: PRODUCT_ID)
-- - OFFLINE_SALE: 테이블과 오프라인 상품 판매 정보를 담은 테이블 (FK: PRODUCT_ID)

-- - PRODUCT 테이블과 OFFLINE_SALE 테이블에서 상품코드 별 매출액(판매가 * 판매량) 합계를 출력하는 SQL문을 작성해주세요. 결과는 매출액을 기준으로 내림차순 정렬해주시고 매출액이 같다면 상품코드를 기준으로 오름차순 정렬해주세요


# [ 메모레 멘탈 모델 ]

-- - 1. 두 테이블을 PK 기준으로 이너 조인한다.
-- - 2. PRODUCT_ID 기준으로 그룹화를 진행한다.
-- - 3. (판매가 * SUM(판매량)) 합계를 SELECT 구문에서 구한다.
-- - 4. 정렬 구체화.

SELECT P.PRODUCT_CODE,
       (P.PRICE * SUM(O.SALES_AMOUNT)) AS SALES
FROM PRODUCT AS P
INNER JOIN OFFLINE_SALE AS O ON P.PRODUCT_ID = O.PRODUCT_ID
GROUP BY P.PRODUCT_ID
ORDER BY SALES DESC, P.PRODUCT_CODE ASC;