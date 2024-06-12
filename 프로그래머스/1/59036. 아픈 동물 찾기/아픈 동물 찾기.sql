-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME -- 동물의 아이디 와 이름을 가져옴 
FROM ANIMAL_INS -- ANIMAL_INS 테이블에서 
WHERE INTAKE_CONDITION = 'Sick' -- 동물의 상태가 'Sick' 일떄
ORDER BY ANIMAL_ID; -- 동물의 아이디를 기준으로 오름차순 정렬