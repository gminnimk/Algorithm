-- 문제: 

-- 종합병원의 진료 예약정보를 담은 테이블: APPOINTMENT

-- APPOINTMENT 테이블에서 2022년 5월에 예약한 환자 수를 진료과코드 별로 조회하는 SQL문을 작성 
-- => (1). '진료예약일시' 에서 날짜 함수 또는 WHERE 조건을 이용해 날짜 조건 지정
-- => (2). '진료과코드 별로' => GROUP BY MCDP_CD
  
-- 이때, 컬럼명은 '진료과 코드', '5월예약건수'로 지정

-- 결과는 진료과별 예약한 환자 수를 기준으로 오름차순 정렬
-- 예약한 환자 수가 같다면 진료과 코드를 기준으로 오름차순 정렬

-- 풀이:
SELECT
    MCDP_CD AS '진료과코드',
    COUNT(APNT_NO) AS '5월예약건수'
FROM
    APPOINTMENT
WHERE
    APNT_YMD LIKE '2022-05%'
GROUP BY
    MCDP_CD
ORDER BY
    COUNT(APNT_NO) ASC, MCDP_CD ASC;
    