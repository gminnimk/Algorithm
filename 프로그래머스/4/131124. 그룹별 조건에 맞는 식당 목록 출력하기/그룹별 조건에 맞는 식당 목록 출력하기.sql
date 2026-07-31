-- [ 문제 ]
-- MEMBER_PROFILE와 REST_REVIEW 테이블에서 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회하는 SQL문을 작성해주세요. 회원 이름, 리뷰 텍스트, 리뷰 작성일이 출력되도록 작성해주시고, 결과는 리뷰 작성일을 기준으로 오름차순, 리뷰 작성일이 같다면 리뷰 텍스트를 기준으로 오름차순 정렬해주세요.

-- MEMBER_PROFILE: 고객의 정보를 담은 테이블
-- REST_REVIEW: 식당의 리뷰 정보를 담은 테이블

SELECT
    M.MEMBER_NAME,
    R.REVIEW_TEXT,
    R.REVIEW_DATE
FROM
    MEMBER_PROFILE AS M
JOIN
    REST_REVIEW AS R ON M.MEMBER_ID = R.MEMBER_ID
WHERE
    -- 서브쿼리를 이용하여 MEMBER_ID 를 그룹화 및 가장 수가 많은 최상단 쿼리
    M.MEMBER_ID = (
        SELECT MEMBER_ID
        FROM REST_REVIEW
        GROUP BY MEMBER_ID
        ORDER BY COUNT(*) DESC
        LIMIT 1
    )
ORDER BY
    R.REVIEW_DATE ASC,
    R.REVIEW_TEXT ASC;