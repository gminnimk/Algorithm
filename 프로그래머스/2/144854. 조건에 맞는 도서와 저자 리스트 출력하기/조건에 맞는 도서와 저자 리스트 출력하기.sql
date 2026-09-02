-- [ 문제 ]

-- - BOOK: 서점에서 판매중인 도서들의 도서 정보 테이블 (FK: AUTHOR_ID)
-- - AUTHOR: 서점에서 판매중읜 도서들의 저자 정보 테이블 (PK: AUTHOR_ID)

-- - '경제' 카테고리에 속하는 도서들의 도서 ID(BOOK_ID), 저자명(AUTHOR_NAME), 출판일(PUBLISHED_DATE) 리스트를 출력하는 SQL문을 작성해주세요.
-- - 결과는 출판일을 기준으로 오름차순 정렬해주세요.

# [ 메모레 멘탈 모델 ]

-- - 1. AUTHOR 테이블 PK 를 기준으로 INNER JOIN을 진행한다
-- - 2. '경제' CATEGORY 의 값을 추출하기 위해 WHERE 조건문으로 필터링을 한다
-- - 3. 출판일 기준 ASC 정렬

SELECT BOOK_ID,
       AUTHOR_NAME,
       PUBLISHED_DATE
FROM AUTHOR AS A
INNER JOIN BOOK AS B ON A.AUTHOR_ID = B.AUTHOR_ID
WHERE B.CATEGORY IN ('경제')
ORDER BY B.PUBLISHED_DATE ASC;