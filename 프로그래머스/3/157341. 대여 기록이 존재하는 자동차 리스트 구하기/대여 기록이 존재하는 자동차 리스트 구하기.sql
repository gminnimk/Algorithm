-- [문제]
-- CAR_RENTAL_COMPANY_CAR 테이블과 CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 자동차 종류가 '세단'인 자동차들 중 10월에 대여를 시작한 기록이 있는 자동차 ID 리스트를 출력하는 SQL문을 작성해주세요. 자동차 ID 리스트는 중복이 없어야 하며, 자동차 ID를 기준으로 내림차순 정렬해주세요.

-- [1단계 : 제한사항 및 예측]
-- - CAR_RENTAL_COMPANY_CAR: 자동차 정보 테이블 (기본 키: CAR_ID, 자동차 종류 포함)
-- - CAR_RENTAL_COMPANY_RENTAL_HISTORY: 대여 기록 테이블 (외래 키: CAR_ID, 대여 시작일 포함)
-- - 예측: 구조가 다른 두 테이블이므로 수직 병합(UNION)이 아닌 가로 연결(JOIN)을 통해 데이터를 조합해야 함. 또한 한 자동차가 10월에 여러 번 대여될 수 있으므로 중복 제거(DISTINCT 또는 GROUP BY)가 필수적임.

-- [2단계 : 핵심 명사 및 동사 추출]
-- - 명사: CAR_ID, CAR_TYPE, START_DATE, 세단, 10월
-- - 동사: 조인하다(JOIN), 필터링하다(WHERE / MONTH), 중복제거하다(DISTINCT), 정렬하다(ORDER BY)

-- [3단계 : 지문 해체 및 기준 수립]
-- - 지문: CAR_ID를 기준으로 두 테이블을 연결(JOIN)한 뒤, 자동차 종류가 '세단'이고 10월 대여 기록이 있는 자동차를 필터링
-- - 기준: 동일한 자동차가 여러 번 대여되었더라도 결과에 자동차 ID가 중복으로 나오지 않도록 처리하는 것이 핵심

-- [4단계 : 요약 및 알고리즘]
-- - (1). CAR 테이블과 HISTORY 테이블을 CAR_ID 기준으로 INNER JOIN 수행
-- - (2). WHERE 절을 통해 CAR_TYPE = '세단' 이고 MONTH(START_DATE) = 10 조건 필터링
-- - (3). SELECT DISTINCT 또는 GROUP BY를 사용해 CAR_ID 중복 제거
-- - (4). ORDER BY CAR_ID DESC 로 내림차순 정렬

-- [5단계 : 방어 논리 구축]
-- - 중복 방어: 한 대의 세단이 10월에 여러 번 대여 기록이 존재할 경우 여러 행이 조회될 수 있으므로 `DISTINCT` 또는 `GROUP BY CAR_ID`를 통해 결과에 중복된 ID가 나타나지 않도록 방어함.


-- [실제 코드 논리]
SELECT DISTINCT C.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR AS C
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H 
  ON C.CAR_ID = H.CAR_ID
WHERE C.CAR_TYPE = '세단' 
  AND MONTH(H.START_DATE) = 10
ORDER BY C.CAR_ID DESC;