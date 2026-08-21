-- [ 문제 ]
-- (1). CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 대여 시작일이 2022년 9월에 속하는 대여 기록에 대해서 대여 기간이 30일 이상이면 '장기 대여' 그렇지 않으면 '단기 대여' 로 표시하는 컬럼(컬럼명: RENT_TYPE)을 추가하여 대여기록을 출력하는 SQL문을 작성해주세요. 

-- - 대여 시작일이 2022년 9월에 속해야 함
-- - => WHERE START_DATE >= '2022-09-01' AND START_DATE < '2022-10-01'

-- - 대여 기간이 30일 이상이면 '장기 대여' 그렇지 않으면 '단기 대여' 로 표시
-- - => CASE WHEN (조건) THEN '장기 대여' ELSE '단기대여' END AS

-- (2). 결과는 대여 기록 ID를 기준으로 내림차순 정렬해주세요.
-- - => ORDER BY HISTORY_ID DESC;

-- CAR_RENTAL_COMPANY_RENTAL_HISTORY: 자동차 대여 기록 정보 테이블
SELECT C.HISTORY_ID,
       C.CAR_ID,
       C.START_DATE,
       C.END_DATE,
       CASE
            WHEN DATEDIFF(C.END_DATE, C.START_DATE) + 1 >= 30 THEN '장기 대여'
            ELSE '단기 대여'
       END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS C
WHERE C.START_DATE >= '2022-09-01' AND C.START_DATE < '2022-10-01'
ORDER BY C.HISTORY_ID DESC;