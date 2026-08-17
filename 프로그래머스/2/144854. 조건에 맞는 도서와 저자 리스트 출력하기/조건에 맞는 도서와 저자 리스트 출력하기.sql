-- [ Step 1: 제한 사항 확인 => 역분석 => 알고리즘 압축 ]

-- (1). "'경제' 카테고리에 속하는 도서들의 ~"
-- => WHERE 조건절 필요

-- (2). "도서 ID(BOOK_ID), 저자명(AUTHOR_NAME), 출판일(PUBLISHED_DATE) 리스트를 출력하"
-- => 각 테이블에 개별적으로 존재하는 컬럼의 값들을 함께 출력해야 하므로 조인 필요


-- [ Step 2: 핵심 명사/동사 키워드 추출 ]

-- 명사: BOOK, AUTHOR, '경제', 도서 ID, 저자명, 출판일
-- 동사: 조인하다, 확인하다(WHERE), 정렬하다


-- [ Step 3: 자료형 및 엣지케이스 검증 ]

-- PUBLISHED_DATE의 데이트 포맷이 예시(2021-02-05)와 동일해야 정답처리 됩니다.



-- [ 요약 ]

-- 주어진 두 테이블을 INNER JOIN 후 WHERE 조건절에 필터링 되는 값들을 정렬하여 출력.



-- [ 문제 ]

-- '경제' 카테고리에 속하는 도서들의 도서 ID(BOOK_ID), 저자명(AUTHOR_NAME), 출판일(PUBLISHED_DATE) 리스트를 출력하는 SQL문을 작성해주세요.
-- 결과는 출판일을 기준으로 오름차순 정렬해주세요.

-- BOOK: 서점에서 판매중인 도서들의 도서 정보 테이블 (PK: BOOK_ID, FK: AUTHOR_ID)
-- AUTHOR: 저자 정보 테이블 (PK: AUTHOR_ID)



-- [ 풀이 ]

SELECT B.BOOK_ID,
       A.AUTHOR_NAME,
       B.PUBLISHED_DATE
FROM BOOK AS B
JOIN AUTHOR AS A ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE B.CATEGORY = '경제'
ORDER BY B.PUBLISHED_DATE ASC;