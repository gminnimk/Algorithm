-- [ 문제 ]

-- - ANIMAL_INS: 동물 보호소에 들어온 동물의 정보를 담은 테이블 (PK: ANIMAL_ID)
-- - ANIMAL_OUTS: 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블 (FK: ANIMAL_ID)

-- - 아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요. 이때 결과는 보호 시작일 순으로 조회해야 합니다.

-- 1. 두 테이블을 INS 기준으로 LEFT JOIN ON ID
-- 2. '가장 오래 보호소에 있었던'
-- 3. ORDER BY DATETIME ASC;

SELECT I.NAME,
       I.DATETIME
FROM ANIMAL_INS AS I
LEFT JOIN ANIMAL_OUTS AS O ON I.ANIMAL_ID = O.ANIMAL_ID
-- 입양을 못 갔으며 & 가장 오래 보호소에 있었던 
WHERE O.ANIMAL_ID IS NULL
ORDER BY I.DATETIME ASC
LIMIT 3;