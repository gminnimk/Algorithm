# =================================================
-- [ 명사/동사 키워드 추출 ]

-- - 명사: 동물의 아이디(ANIMAL_ID), 생물 종(ANIMAL_TYPE), 보호 시작일(DATETIME), 보호 시작 시 상태(INTAKE_CONDITION), 이름(NAME), 성별 및 중성화 여부(SEX_UPON_INTAKE), / 입양일(DATETIME),
-- - 동사: 조인하다(JOIN), 정렬하다(ORDER BY)
# =================================================

# =================================================
-- [ 엣지케이스 ]

-- - 중성화를 거치지 않은 동물은 성별 및 중성화 여부에 Intact, 중성화를 거친 동물은 Spayed 또는 Neutered라고 표시되어있습니다. 
# =================================================

# =================================================
-- [ 문제 ]
-- ANIMAL_INS: 동물 보호소에 들어온 동물의 정보를 담은 테이블 (PK: ANIMAL_ID)
-- ANIMAL_OUTS: 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블 (FK: ANIMAL_ID)

-- 보호소에서 중성화 수술을 거친 동물 정보를 알아보려 합니다. 보호소에 들어올 당시에는 중성화 되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문을 작성해주세요.

-- 1. "보호소에 들어올 당시에는 중성화 되지 않았지만, 보호소를 나갈 당시 중성화된 동물의 아이디와 생물 종" 을 추출하는게 목적이므로 두 테이블을 INNER JOIN 한다.
-- 2. 중성화 여부(SEX_UPON_INTAKE)를 비교하여 I.SEX_UPON_INTAKE 에서는 Intact 표기로 되어있으면서 O.SEX_UPON_INTAKE 에서는 Spayed 또는 Neutered 표기를 찾는다 (WHERE 조건을 이용해서)
# =================================================

-- [ 풀이 ]
SELECT I.ANIMAL_ID,
       I.ANIMAL_TYPE,
       I.NAME
FROM ANIMAL_INS AS I
JOIN ANIMAL_OUTS AS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.SEX_UPON_INTAKE LIKE 'Intact%'
  AND O.SEX_UPON_OUTCOME IN ('Spayed Male', 'Spayed FeMale', 'Neutered Male', 'Neutered FeMale')
ORDER BY I.ANIMAL_ID ASC;