-- REST_INFO: 식당의 정보를 담은 테이블

-- 음식종류별로 즐겨찾기수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회하는 SQL?
-- 결과는 음식 종류를 기준으로 내림차순 정렬

SELECT
    FOOD_TYPE,
    REST_ID,
    REST_NAME,
    FAVORITES
FROM
    REST_INFO
-- ID 와 식당 이름 또한 음식종류별 즐겨찾기가 제일 많은 곳이어야 하므로
-- 서브쿼리 조건 필요
WHERE
    (FOOD_TYPE, FAVORITES) IN (
        SELECT
            FOOD_TYPE,
            MAX(FAVORITES)
        FROM
            REST_INFO
        GROUP BY
            FOOD_TYPE
    )
GROUP BY
    FOOD_TYPE
ORDER BY
    FOOD_TYPE DESC;