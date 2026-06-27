-- [문제] APPOINTMENT 테이블에서 2022년 5월에 예약한 환자 수를 진료과코드 별로 조회하는 SQL문 작성

-- 종합병원의 진료 예약정보 테이블 APPOINTMENT
-- '진료과코드 별로' => GROUP BY MCDP_CD
-- '2022년 5월에' => WHERE DATE_FORMAT OR LIKE?

-- (1). 컬럼명은 '진료과 코드', '5월예약건수'로 지정
-- => AS 로 별칭 사용

-- (2). 결과는 진료과별 예약한 환자 수를 기준으로 오름차순 정렬 & 예약한 환자 수가 같다면 진료과 코드를 기준으로 오름차순 정렬
-- =>  ORDER BY ASC COUNT(APNT_NO) & MCDP_CD


-- [풀이]
SELECT
    MCDP_CD AS '진료과 코드',
    COUNT(APNT_NO) AS '5월예약건수'
FROM
    APPOINTMENT
WHERE APNT_YMD LIKE '2022-05%'
GROUP BY MCDP_CD
ORDER BY COUNT(APNT_NO), MCDP_CD;