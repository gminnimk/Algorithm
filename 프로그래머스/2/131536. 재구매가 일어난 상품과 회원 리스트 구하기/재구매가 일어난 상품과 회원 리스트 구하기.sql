# ==================================================================
# [ 명사/동사 키워드 추출 ]
-- - 명사: ONLINE_SALE_ID(온라인 상품 판매 ID), USER_ID(회원 ID), PRODUCT_ID(상품 ID), SALES_AMOUNT(판매량), SALES_DATE(판매일)
# ==================================================================

# ==================================================================
# [ 문제 ]
-- - ONLINE_SALE: 의류 쇼핑몰의 온라인 상품 판매 정보를 담은 테이블

-- - ONLINE_SALE 테이블에서 동일한 회원(O.USER_ID)이 동일한 상품(O.PRODUCT_ID)을 재구매한 데이터를 구하여, 재구매한 회원 ID와 재구매한 상품 ID를 출력하는 SQL문을 작성해주세요.
-- => USER_ID 

-- - 결과는 회원 ID를 기준으로 오름차순 정렬해주시고 회원 ID가 같다면 상품 ID를 기준으로 내림차순 정렬해주세요.
-- => ORDER BY O.USER_ID ASC, PRODUCT_ID DESC;
# ==================================================================

# [ 풀이 ]
SELECT USER_ID,
       PRODUCT_ID
FROM ONLINE_SALE AS O
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(*) >= 2
ORDER BY USER_ID ASC, PRODUCT_ID DESC;