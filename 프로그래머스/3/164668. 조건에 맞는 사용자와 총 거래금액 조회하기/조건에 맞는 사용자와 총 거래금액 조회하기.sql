# [ 문제 ]

-- - USED_GOODS_BOARD: 중고 거래 게시판 정보를 담은 테이블 (PK: BOARD_ID, WRITER_ID)
-- - USED_GOODS_USER: 중고 거래 게시판 사용자 정보를 담은 테이블 (PK: USER_ID)

-- - USED_GOODS_BOARD와 USED_GOODS_USER 테이블에서 완료된 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID, 닉네임, 총거래금액을 조회하는 SQL문을 작성해주세요. 결과는 총거래금액을 기준으로 오름차순 정렬해주세요.


# [ 메모리 멘탈 모델 ]

-- - 1. 두 테이블에서 '완료된 중고 거래의 총금액이 70만원 이상인 사람'을 구하는게 목적
-- - 2. 공통적으로 존재하는 데이터를 뽑아야 하므로 (게시판 정보와 사용자) INNER JOIN
-- - 3. 완료된 중고 거래 총금액을 구해야 하므로 회원ID 기준 그룹화 집계를 한다. => 그래야 게시판의 중복된 작성자 데이터를 집계할 수 있으니까
-- - 4. HAVING 절에 '총금액 70만원 이상' 조건식 구축
-- - 4. SELECT 절에 SUM 집계 함수를 이용하여 총거래금액 구한다 
-- - 5. 총거래금액 기준으로 오름차순 정렬

SELECT U.USER_ID,
       U.NICKNAME,
       SUM(B.PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD AS B
INNER JOIN USED_GOODS_USER AS U ON B.WRITER_ID = U.USER_ID
WHERE B.STATUS IN ('DONE')
GROUP BY U.USER_ID
HAVING SUM(B.PRICE) >= '700000'
ORDER BY TOTAL_SALES ASC;