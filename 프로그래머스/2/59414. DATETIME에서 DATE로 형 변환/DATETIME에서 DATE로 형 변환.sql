-- 코드를 입력하세요
SELECT ANIMAL_ID,
       NAME, 
       SUBSTR(DATETIME,1,10) as "날짜"
FROM ANIMAL_INS
ORDER BY ANIMAL_ID

