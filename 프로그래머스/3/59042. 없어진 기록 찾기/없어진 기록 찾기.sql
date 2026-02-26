-- ANIMAL_INS: 동물 보호소에 들어온 동물의 정보를 담은 테이블
-- ANIMAL_OUTS: 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블

-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL?
SELECT 
    AO.ANIMAL_ID,
    AO.NAME
FROM 
    ANIMAL_OUTS AS AO 
LEFT JOIN 
    ANIMAL_INS AS AI ON AO.ANIMAL_ID = AI.ANIMAL_ID
WHERE
    AI.ANIMAL_ID IS NULL
ORDER BY
    AO.ANIMAL_ID;