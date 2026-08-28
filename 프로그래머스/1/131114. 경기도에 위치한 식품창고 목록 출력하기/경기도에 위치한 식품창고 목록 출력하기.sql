# ========================================================
-- [ 명사/동사 키워드 추출 ]

-- - 명사: 창고 ID(WAREHOUSE_ID), 창고 이름(WAREHOUSE_NAME), 창고 주소(ADDRESS), 전화번호(TLNO), 냉동시설 여부(FREEZER_YN)
-- - 동사: IFNULL, 정렬하다(ORDER BY)
# ========================================================

# ========================================================
-- [ 문제 ]

-- - FOOD_WAREHOUSE: 식품창고의 정보를 담은 테이블
-- - FOOD_WAREHOUSE 테이블에서 경기도에 위치한 창고의 ID, 이름, 주소, 냉동시설 여부를 조회하는 SQL문을 작성해주세요. 이때 냉동시설 여부가 NULL인 경우, 'N'으로 출력시켜 주시고 결과는 창고 ID를 기준으로 오름차순 정렬해주세요.

-- - "경기도에 위치한" => WHERE 필터링
-- - "냉동시설 여부가 NULL인 경우, 'N'으로 출력" => IFNULL 함수
-- - "결과는 창고 ID를 기준으로 오름차순 정렬" => ORDER BY WAREHOUSE_ID ASC
# ========================================================

SELECT WAREHOUSE_ID,
       WAREHOUSE_NAME,
       ADDRESS,
       IFNULL(FREEZER_YN, 'N') AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기도%'
ORDER BY WAREHOUSE_ID ASC;