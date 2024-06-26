SELECT MCDP_CD AS '진료과코드' -- 진료과 코드 
, COUNT(MCDP_CD) AS '5월예약건수' -- 진료예약일시
FROM APPOINTMENT 
WHERE 1=1
AND APNT_YMD LIKE '2022-05%'
-- LIKE : 특정 문자 또는 문자열을 포함하고 있는 값을 검색하고 싶을 때 사용
GROUP BY MCDP_CD
-- GROUP BY : 특정 컬럼을 그룹화
ORDER BY COUNT(MCDP_CD), MCDP_CD


