-- USED_GOODS_BOARD: 중고 거래 게시판 정보 테이블
-- USED_GOODS_USER: 중고 거래 게시판 사용자 정보


-- [문제] USED_GOODS_BOARD와 USED_GOODS_USER 테이블에서 완료된 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID, 닉네임, 총거래금액을 조회하는 SQL문을 작성. 결과는 총거래금액을 기준으로 오름차순 정렬.

-- (1). '완료된 중고 거래의 총금액이 70만 원 이상인 사람'
-- => STATUS = DONE / SUM(PRICE) >= '700000'


-- (2). 총거래금액을 기준으로 오름차순 정렬
-- => ORDER BY TOTAL_SALES ASC

-- [풀이]
SELECT
    USER_ID,
    NICKNAME,
    SUM(PRICE) AS TOTAL_SALES
FROM
    USED_GOODS_BOARD
JOIN
    USED_GOODS_USER ON WRITER_ID = USER_ID
WHERE STATUS = 'DONE'
GROUP BY USER_ID
HAVING SUM(PRICE) >= '700000'
ORDER BY TOTAL_SALES;