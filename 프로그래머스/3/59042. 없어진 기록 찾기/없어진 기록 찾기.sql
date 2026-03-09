-- ANIMAL_INS: 동물 보호소에 들어온 동물의 정보를 담은 테이블
-- ANIMAL_OUTS: 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블

-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는: LEFT JOIN
-- 동물의 ID와 이름을: SELECT ANIMAL_ID, NAME
-- ID순으로 조회: ORDER BY ID

SELECT
    AO.ANIMAL_ID,
    AO.NAME
FROM
    ANIMAL_OUTS AS AO
LEFT JOIN
    ANIMAL_INS AS AI ON AO.ANIMAL_ID = AI.ANIMAL_ID
WHERE
    AI.DATETIME IS NULL
ORDER BY
    AO.ANIMAL_ID;