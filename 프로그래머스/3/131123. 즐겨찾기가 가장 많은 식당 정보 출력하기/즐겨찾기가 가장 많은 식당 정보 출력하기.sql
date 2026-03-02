-- REST_INFO: 식당의 정보를 담은 테이
-- 음식종류별로 즐겨찾기수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회하는 SQL?
-- => 음식종류별: GROUP BY FOOD_TYPE
-- => 즐겨찾기수가 가장 많은: SELECT MAX(FAVORITES)
-- => 음식 종류, ID, 식당 이름, 즐겨찾기수를 위의 조건을 충족해서 출력해야 하므로: 서브쿼리에 위 조건을 기입해야 함 (안 그러면 ID와 이름은 상관없는 값이 출력할 수 있기에)

-- 결과는 음식 종류를 기준으로 내림차순 정렬: DESC

SELECT
    FOOD_TYPE,
    REST_ID,
    REST_NAME,
    FAVORITES
FROM
    REST_INFO
WHERE
    -- 서브 쿼리 조건 삽입
    (FOOD_TYPE, FAVORITES) IN (
        SELECT
            FOOD_TYPE,
            MAX(FAVORITES)
        FROM
            REST_INFO
        GROUP BY
            FOOD_TYPE
    )
ORDER BY
    FOOD_TYPE DESC;