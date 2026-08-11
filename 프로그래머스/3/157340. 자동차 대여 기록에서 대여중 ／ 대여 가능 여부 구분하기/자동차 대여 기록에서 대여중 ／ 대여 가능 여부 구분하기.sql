-- [ 문제 ]
-- CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 2022년 10월 16일에 대여 중인 자동차인 경우 '대여중' 이라고 표시하고, 대여 중이지 않은 자동차인 경우 '대여 가능'을 표시하는 컬럼(컬럼명: AVAILABILITY)을 추가하여 자동차 ID와 AVAILABILITY 리스트를 출력하는 SQL문을 작성해주세요. 이때 반납 날짜가 2022년 10월 16일인 경우에도 '대여중'으로 표시해주시고 결과는 자동차 ID를 기준으로 내림차순 정렬해주세요.

-- CAR_RENTAL_COMPANY_RENTAL_HISTORY: 자동차 대여 기록 정보 테이블

-- [ 지문 해제 ]
-- (1). 2022년 10월 16일 => = 연산자 및 CASE THEN 구문 사용
-- (2). '대여' 여부를 자동차별로 판단하면 되기에 'CAR_ID'를 그룹화


-- [ 코드 풀이 ]
SELECT C.CAR_ID,
       -- CASE THEN 식 필요
       -- (1). START_DATE ~ END_DATE 사이에 '2022-10-16' 포함되지 않으면 '대여가능'
       -- (2). 그 외에는 '대여중' 이라고 표기
       CASE
            WHEN MAX(C.START_DATE <= '2022-10-16' AND C.END_DATE >= '2022-10-16') = 1 THEN '대여중'
            ELSE '대여 가능'
       END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS C
GROUP BY C.CAR_ID
ORDER BY C.CAR_ID DESC;