-- [ Step1: 제한 사항 확인 => 역분석 => 알고리즘 압축 ]
-- (1). PRODUCT 테이블과 OFFLINE_SALE 테이블에서 상품코드 별 매출액(판매가 * 판매량) 합계를 출력
-- => 두 테이블이 필연적으로 JOIN 이 되어야하며
-- => "상품코드 별" 이므로 GROUP BY PRODUCT_CODE
-- => "매출액(판매가 * 판매량) 합계" => SUM 집계 함수를 이용

-- [ Step2: 핵심 명사/동사 키워드 추출 ]
-- 명사: PRODUCT, OFFLIME_SALE, 상품코드, 매출액(판매가 & 판매량)
-- 동사: 조인하다, 집계하다, 더하다(합계), 정렬하다


-- [ 문제 ]

-- PRODUCT 테이블과 OFFLINE_SALE 테이블에서 상품코드 별 매출액(판매가 * 판매량) 합계를 출력하는 SQL문을 작성.
-- 결과는 매출액을 기준으로 내림차순 정렬해주시고 매출액이 같다면 상품코드를 기준으로 오름차순 정렬해주세요.

-- PRODUCT: 판매중인 상품들의 상품 정보 테이블 (PK: PRODUCT_ID, UK: PRODUCT_CODE)
-- OFFLINE_SALE: 오프라인 상품 판매 정보 테이블 (PK: OFFLINE_SALE_ID, FK: PRODUCT_ID)


-- [ 풀이 ]

SELECT PRODUCT_CODE,
       SUM(P.PRICE * O.SALES_AMOUNT) AS SALES
FROM PRODUCT AS P
JOIN OFFLINE_SALE AS O ON P.PRODUCT_ID = O.PRODUCT_ID
GROUP BY P.PRODUCT_CODE
ORDER BY SALES DESC,
         P.PRODUCT_CODE ASC;