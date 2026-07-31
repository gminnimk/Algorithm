-- 도서 정보(BOOK)
-- 저자 정보(AUTHOR)

-- '경제' 카테고리에 속하는 도서들의 도서 ID(BOOK_ID), 저자명(AUTHOR_NAME), 출판일(PUBLISHED_DATE) 리스트를 출력하는 SQL문을 작성해주세요.
-- 결과는 출판일을 기준으로 오름차순 정렬해주세요.
SELECT
    BOOK_ID,
    AUTHOR_NAME,
    PUBLISHED_DATE
FROM
    BOOK AS B
JOIN
    AUTHOR AS A ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE
    B.CATEGORY LIKE '경제'
ORDER BY
    B.PUBLISHED_DATE;