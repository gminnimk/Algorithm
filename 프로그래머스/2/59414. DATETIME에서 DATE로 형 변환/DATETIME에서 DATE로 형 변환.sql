-- ANIMAL_INS: 동물 보호소에 들어온 동물의 정보를 담은 테이블

-- 각 동물의 아이디와 이름, 들어온 날짜를 조회하는 SQL?

SELECT
    ANIMAL_ID,
    NAME, 
    DATE_FORMAT(DATETIME, '%Y-%m-%d') AS "날짜"
FROM
    ANIMAL_INS
-- 이때 결과는 아이디 순으로 조회
ORDER BY
    ANIMAL_ID