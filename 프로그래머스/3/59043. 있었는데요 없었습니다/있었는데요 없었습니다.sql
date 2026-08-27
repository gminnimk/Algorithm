# =================================================================
# [ 명사/동사 키워드 추출 ]
-- - 명사: 동물의 아이디(ANIMAL_ID), 생물 종(ANIMAL_TYPE), 보호 시작일(DATETIME), 보호 시작 시 상태(INTAKE_CONDITION), 이름(NAME), 성별 및 중성화 여부(SEX_UPON_INTAKE / SEX_UPON_OUTCOME)
-- - 동사: 조인하다(JOIN), 정렬하다(ORDER BY)
# =================================================================

# =================================================================
# [ 문제 ]
-- - ANIMAL_INS: 동물 보호소에 들어온 동물의 정보를 담은 테이블 (PK: ANIMAL_ID)
-- - ANIMAL_OUTS: 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블 (FK: ANIMAL_ID)

-- - 일부 동물의 입양일(O.DATETIME)이 잘못 입력됨
-- - 보호 시작일(I.DATETIME)보다 입양일(O.DATETIME)이 더 빠른 동물의 아이디와 이름을 조회
-- => 해당 조건을 추출할려면
-- 1. 두 테이블을 ON PK 로 INNER JOIN 을 한다.
-- 2. WHERE 조건식을 세운다 (I.DATETIME > O.DATETIME)

-- - 결과는 보호 시작일이 빠른 순으로 조회
-- => ORDER BY I.DATETIME ASC;
# =================================================================

SELECT I.ANIMAL_ID,
       I.NAME
FROM ANIMAL_INS AS I
JOIN ANIMAL_OUTS AS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.DATETIME > O.DATETIME
ORDER BY I.DATETIME ASC;