-- ANIMAL_INS: 동물 보호소에 들어온 정보를 담은 테이블
-- ANIMAL_OUTS: 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블

-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL?
-- 결과는 보호 시작일이 빠른 순으로 조회

SELECT
    AO.ANIMAL_ID,
    AO.NAME
FROM
    ANIMAL_OUTS AS AO
LEFT JOIN 
    ANIMAL_INS AS AI
ON
    AO.ANIMAL_ID = AI.ANIMAL_ID
WHERE
    AO.DATETIME < AI.DATETIME
ORDER BY
    AI.DATETIME;