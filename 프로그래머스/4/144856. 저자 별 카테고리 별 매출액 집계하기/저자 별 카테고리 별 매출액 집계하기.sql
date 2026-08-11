-- [ 문제 ]
-- 2022년 1월의 도서 판매 데이터를 기준으로 저자 별, 카테고리 별 매출액(TOTAL_SALES = 판매량 * 판매가) 을 구하여, 저자 ID(AUTHOR_ID), 저자명(AUTHOR_NAME), 카테고리(CATEGORY), 매출액(SALES) 리스트를 출력하는 SQL문을 작성해주세요.

-- BOOK: 판매중인 도서들의 도서 정보
-- AUTHOR: 판매중인 도서들의 저자 정보
-- BOOK_SALES: 각 도서의 날짜 별 판매량 정보 테이블

-- [ 지문 해제 ]
-- (1). 두 테이블 INNER JOIN
-- (2). '2022년 1월의 도서 판매 데이터를 기준' / '저자, 카테고리 별' => 그룹화 및 WHERE 조건

-- [ 코드 풀이 ]
SELECT A.AUTHOR_ID,
       A.AUTHOR_NAME,
       B.CATEGORY,
       SUM(S.SALES * B.PRICE) AS TOTAL_SALES
FROM BOOK AS B
JOIN AUTHOR AS A
ON B.AUTHOR_ID = A.AUTHOR_ID
JOIN BOOK_SALES AS S
ON B.BOOK_ID = S.BOOK_ID

-- '2022년 1월의 도서 판매 데이터를 기준' => 그룹화 전 선행되어야 함
WHERE S.SALES_DATE >= '2022-01-01'
AND S.SALES_DATE < '2022-02-01'
GROUP BY A.AUTHOR_ID,
         B.CATEGORY
-- 결과는 저자 ID를 오름차순으로, 저자 ID가 같다면 카테고리를 내림차순 정렬해주세요.
ORDER BY A.AUTHOR_ID ASC,
         B.CATEGORY DESC;