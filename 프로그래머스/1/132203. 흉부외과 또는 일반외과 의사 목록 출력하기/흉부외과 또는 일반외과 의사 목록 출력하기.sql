SELECT DR_NAME, -- DR_NAME 컬럼 가져오기 
       DR_ID, -- DR_ID 컬럼 가져오기
       MCDP_CD, -- MCDP_CD 컬럼 가져오기
       SUBSTR(HIRE_YMD,1,10) AS HIRE_YMD -- HIRE_YMD 이름으로 표기하고 HIRE_YMD 컬럼에서 1번째 ~ 10번째 까지 추출 
FROM DOCTOR -- DOCTOR 테이블 불러오기
WHERE MCDP_CD IN ('CS', 'GS') -- MCDP_CD 즉, 진료과 코드가 CS 이거나 GS 인 코드의 조건에서 
ORDER BY HIRE_YMD DESC, DR_NAME ASC -- HIRE_YMD 기준으로 내림차순 정렬, DR_NAME 기준으로 오름차순 정렬