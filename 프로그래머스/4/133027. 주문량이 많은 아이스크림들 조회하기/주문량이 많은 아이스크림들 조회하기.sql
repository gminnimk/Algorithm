-- [ 문제 ]
-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회하는 SQL 문을 작성해주세요.

-- FIRST_HALF: 아이스크림 가게의 상반기 주문 정보 테이블
-- JULY: 7월의 아이스크림 주문 정보를 담은 테이블
SELECT
    A.FLAVOR
FROM (
    SELECT FLAVOR, TOTAL_ORDER FROM FIRST_HALF
    UNION ALL
    SELECT FLAVOR, TOTAL_ORDER FROM JULY
) AS A
GROUP BY A.FLAVOR
ORDER BY SUM(A.TOTAL_ORDER) DESC
LIMIT 3;