-- [ 명사/동사 키워드 추출 ]
-- - 명사: 동물 보호소에 들어온 동물의 정보를 담은 테이블, 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블
-- - 동사: 조인하다, 정렬하다


-- [ 문제 ]
-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성해주세요.

-- ANIMAL_INS: 동물 보호소에 들어온 동물의 정보를 담은 테이블 (PK: ANIMAL_ID)
-- ANIMAL_OUTS: 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블 (FK: ANIMAL_ID)

-- - (1). "입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물"
-- - => ANIMAL_OUTS LEFT JOIN ANIMAL_INS 를 해야 INS 의 NULL 값을 조회할 수 있음

-- - (2). 동물의 ID와 이름을 ID 순으로 조회
-- - => ORDER BY ANIMAL_ID, NAME;


-- [ 풀이 ]
SELECT O.ANIMAL_ID,
       O.NAME
FROM   ANIMAL_OUTS AS O
LEFT JOIN ANIMAL_INS AS I ON I.ANIMAL_ID = O.ANIMAL_ID
-- 입양을 보낸 기록(OUTS)을 기준으로 보호소(INS)의 없는 ID를 필터링 
WHERE I.ANIMAL_ID IS NULL
ORDER BY O.ANIMAL_ID, O.NAME ASC;