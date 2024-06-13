SELECT ANIMAL_TYPE, -- 생물 종 컬럼을 가져옴
       COUNT(ANIMAL_TYPE) AS COUNT  -- 생물 종의 숫자를 COUNT 로 표시 및 출력 
FROM ANIMAL_INS -- ANIMAL_INS 테이블에서 가져옴
GROUP BY ANIMAL_TYPE -- 생물 종을 그룹 별로
ORDER BY ANIMAL_TYPE -- 생물 종을 오름차순으로 정렬 
