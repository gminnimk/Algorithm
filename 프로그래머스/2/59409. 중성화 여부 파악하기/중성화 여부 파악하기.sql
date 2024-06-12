SELECT ANIMAL_ID, -- 동물의 아이디 컬럼 가져오기 
       NAME, -- 동물의 이름 컬럼 가져오기 
       CASE 
           WHEN SEX_UPON_INTAKE LIKE '%Neutered%' OR SEX_UPON_INTAKE LIKE '%Spayed%' THEN 'O'
           ELSE 'X'
       END AS '중성화' -- CASE 문을 사용해서 성별 및 중성화 여부 컬럼에 'Neutered' 또는 'Spayed' 단어가 들어있다면 O 출력 아닐시 X 출력 / 컬럼 이름은 "중성화"로 설정 
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;



