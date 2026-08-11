-- 문제
-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회하는 SQL 문을 작성해주세요.
-- [A 조건] 7월에는 아이스크림 주문량이 많아 같은 아이스크림에 대하여 서로 다른 두 공장에서 아이스크림 가게로 출하를 진행하는 경우가 있습니다. 이 경우 같은 맛의 아이스크림이라도 다른 출하 번호를 갖게 됩니다.
-- => FLAVOR 로 그룹화 진행

-- FIRST_HALF: 상반기 주문 정보 테이블 (PK: FLAVOR, FK: SHIPMENT_ID)
-- JULY: 7월의 아이스크림 주문 정보 테이블 (PK: SHIPMENT_ID, FK: FLAVOR)

-- [ 지문 해제 ]
-- '7월 아이스크림 총 주문량' (J.TOTAL_ORDER), '상반기의 아이스크림 총 주문량' (F.TOTAL_ORDER)의 더한 값이 큰 순서대로 상위 3개의 맛을 조회
-- (1). 두 테이블의 값이 존재하는 행들의 값을 구해야 하므로 INNER JOIN (ON FLAVOR)
-- (2). [A 조건]에 따라 FLAVOR 로 그룹화가 필요 (그래야 출하 번호가 달라도 집계 합산이 가능하므로)
-- (3). 상위 3개의 맛을 조회 => WHERE 조건에서 3개의 값만 추출하도록 설정 또는 SELECT 문에서 서브쿼리를 이용하면 되지 않을까?


SELECT F.FLAVOR
FROM FIRST_HALF AS F
-- [A 조건] 에 따라서 그냥 조인을 하면 중복 행으로 인해 결과의 오류가 나타날 수 있음
-- 따라서 JULY 테이블에 대해 먼저 FLAVOR 별 TOTAL_ORDER 집계 합산 값을 인라인 VIEW 로 구해놓고 JOIN을 처리하기
JOIN (SELECT FLAVOR,
             SUM(TOTAL_ORDER) AS TOTAL_ORDER
      FROM JULY
      GROUP BY FLAVOR
     ) AS J
ON F.FLAVOR = J.FLAVOR
ORDER BY (F.TOTAL_ORDER + J.TOTAL_ORDER) DESC
LIMIT 3;
