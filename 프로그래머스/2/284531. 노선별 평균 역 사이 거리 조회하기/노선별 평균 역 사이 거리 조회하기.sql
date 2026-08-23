# ============================================================
-- [ 명사/동사 키워드 추출 ]
-- - 명사: 2호선의 역 간 거리 정보를 담은 테이블(SUBWAY_DISTANCE), 호선(LINE), 순번(NO), 노선(ROUTE), 역 이름(STATION_NAME), 역 사이 거리(D_BTWEEN_DIST), 노선별 누계 거리(D_CUMULATIVE)
-- - 동사: 그룹화하다(GROUP BY), 합계하다(SUM), 평균을 구하다(AVG), 반올림하다(ROUND), 이어 붙이다(CONCAT)
# ============================================================

# ============================================================
-- [ 문제 ]
-- - SUBWAY_DISTANCE: 2호선의 역 간 거리 정보를 담은 테이블

-- - SUBWAY_DISTANCE 테이블에서 노선별로 노선, 총 누계 거리, 평균 역 사이 거리를 노선별로 조회하는 SQL문을 작성해주세요.
-- "노선별로" => GROUP BY ROUTE

-- - 총 누계거리는 테이블 내 존재하는 역들의 역 사이 거리의 총 합을 뜻합니다. 총 누계 거리와 평균 역 사이 거리의 컬럼명은 각각 TOTAL_DISTANCE, AVERAGE_DISTANCE로 해주시고, 총 누계거리는 소수 둘째자리에서, 평균 역 사이 거리는 소수 셋째 자리에서 반올림 한 뒤 단위(km)를 함께 출력해주세요.
-- "총 누계거리는 테이블 내 존재하는 역들의 역 사이 거리의 총 합을 뜻합니다" => SUM(D_BETWEEN_DIST)
-- "평균 역 사이 거리" => AVG(D_BETWEEN_DIST)
-- "총 누계거리는 소수 둘째자리에서, 평균 역 사이 거리는 소수 셋째 자리에서 반올림 한 뒤 단위(km)" => ROUND 함수, CONCAT 함수

# 결과는 총 누계 거리를 기준으로 내림차순 정렬해주세요.
-- => ORDER BY DESC;
# ============================================================

-- [ 풀이 ]
SELECT S.ROUTE,
       CONCAT(ROUND(SUM(S.D_BETWEEN_DIST), 1), 'km') AS TOTAL_DISTANCE,
       CONCAT(ROUND(AVG(S.D_BETWEEN_DIST), 2), 'km') AS AVERAGE_DISTANCE
FROM SUBWAY_DISTANCE AS S
GROUP BY S.ROUTE
ORDER BY SUM(S.D_BETWEEN_DIST) DESC;