-- [ 문제 ]
-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회하는 SQL 문을 작성해주세요.

-- [ 제한 사항 ]
-- 7월에는 아이스크림 주문량이 많아 같은 아이스크림에 대하여 서로 다른 두 공장에서 아이스크림 가게로 출하를 진행하는 경우가 있습니다. 이 경우 같은 맛의 아이스크림이라도 다른 출하 번호를 갖게 됩니다.
-- => 단순히 그룹화만 하면 어떤 'SHIPMENT_ID'의 아이스크림 TOTAL_ORDER 인지를 읽어오지 못 하는 리스크가 존재

-- FIRST_HALF: 상반기 주문 정보 테이블 (PK: FLAVOR, FK: SHIPMENT_ID)
-- JULY: 7월 아이스크림 주문 정보 테이블 (PK: SHIPMENT_ID, FK: FLAVOR)


-- [ 지문 해제 ]
-- (1). 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값
-- - 두 테이블을 PK(FLAVOR) 기준 JOIN 해준다.
-- - JULY '제한 사항'을 고려했을때 인라인 뷰를 활용하여 TOTAL_ORDER 를 미리 SUM 함수로 계산한다. (계산된 테이블을 가져와야 하므로 FROM 구문에서 진행)

-- (2). 상위 3개의 맛을 조회 => LIMIT 3


-- [ 실제 코드 흐름 ]
SELECT F.FLAVOR
FROM FIRST_HALF AS F
JOIN (
    SELECT FLAVOR,
           SUM(TOTAL_ORDER) AS TOTAL_ORDER
    FROM JULY
    GROUP BY FLAVOR
) AS J ON F.FLAVOR = J.FLAVOR
ORDER BY (F.TOTAL_ORDER + J.TOTAL_ORDER) DESC
LIMIT 3;
