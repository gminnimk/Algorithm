-- ANIMAL_INS 테이블에서 ANIMAL_ID와 NAME 컬럼을 선택
SELECT ANIMAL_ID, NAME 
FROM ANIMAL_INS 

-- ANIMAL_TYPE이 'Dog'인 행만 선택
WHERE ANIMAL_TYPE = "Dog" 

-- NAME 컬럼에 'EL'이 포함된 행만 선택
AND NAME LIKE "%EL%" 

-- 결과를 NAME 컬럼을 기준으로 오름차순으로 정렬
ORDER BY NAME ASC;