-- [ 문제 ]
-- CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 2022년 10월 16일에 대여 중인 자동차인 경우 '대여중' 이라고 표시하고, 대여 중이지 않은 자동차인 경우 '대여 가능'을 표시하는 컬럼(컬럼명: AVAILABILITY)을 추가하여 자동차 ID와 AVAILABILITY 리스트를 출력하는 SQL문을 작성해주세요. -- 이때 반납 날짜가 2022년 10월 16일인 경우에도 '대여중'으로 표시

-- CAR_RENTAL_COMPANY_RENTAL_HISTORY : 자동차 대여 기록 정보 테이블

SELECT
    C.CAR_ID,
    -- 대여 시작일 ~ 종료일 사이에 대여 이력이 하나라도 존재한다면 => 대여중 else 대여 가능
    CASE
        WHEN MAX(
            CASE WHEN '2022-10-16' BETWEEN START_DATE AND END_DATE THEN 1 ELSE 0 END
        ) = 1 THEN '대여중' ELSE '대여 가능' END
    AS AVAILABILITY
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY AS C
GROUP BY
    C.CAR_ID
ORDER BY
    -- 결과는 자동차 ID를 기준으로 내림차순 정렬
    C.CAR_ID DESC;