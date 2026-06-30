-- [문제]

-- 중고 거래 게시판 정보를 담은 테이블: USED_GOODS_BOARD
-- 중고 거래 게시판 사용자 정보를 담은 테이블: USED_GOODS_USER

-- USED_GOODS_BOARD와 USED_GOODS_USER 테이블에서 완료된 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID, 닉네임, 총거래금액을 조회하는 SQL문?
-- '완료된 중고 거래의 총금액이 70만 원 이상' => WHERE STATUS = 'DONE' AND TOTAL_SALES > 700000

-- 결과는 총거래금액을 기준으로 오름차순 정렬
-- => ORDER BY ASC

-- [풀이]
SELECT
    USER_ID,
    NICKNAME,
    SUM(PRICE) AS TOTAL_SALES
FROM
    USED_GOODS_BOARD AS UGB
JOIN
    USED_GOODS_USER AS UGU ON UGB.WRITER_ID = UGU.USER_ID
WHERE
    STATUS = 'DONE'
GROUP BY
    WRITER_ID
HAVING
    SUM(PRICE) >= 700000
ORDER BY
    TOTAL_SALES ASC;