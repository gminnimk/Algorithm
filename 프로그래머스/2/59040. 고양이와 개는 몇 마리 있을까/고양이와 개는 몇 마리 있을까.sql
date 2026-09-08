# [ 문제 ]

-- - ANIMAL_INS: 동물 보호소에 들어온 동물의 정보를 담은 테이블 (PK: ANIMAL_ID)
-- - 동물 보호소에 들어온 동물 중 고양이와 개가 각각 몇 마리인지 조회하는 SQL문을 작성해주세요. 이때 고양이를 개보다 먼저 조회해주세요.

# [ 메모리 멘탈 모델 ]

-- - 1. ANIMAL_TYPE 으로 그룹화 진행 및 COUNT 집계함수로 쿼리 출력
-- - 2. 고양이가 먼저오도록 정렬 기준

SELECT ANIMAL_TYPE,
       COUNT(ANIMAL_ID) AS count
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE ASC;