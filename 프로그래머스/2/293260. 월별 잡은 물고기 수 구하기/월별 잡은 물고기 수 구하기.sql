-- [ 명사/동사 키워드 추출 ]
-- - 명사: FISH_INFO(잡은 물고기들의 정보를 담은 테이블), 물고기의 ID(ID), 물고기의 종류(FISH_TYPE), 물고기의 길이(LENGTH), 물고기를 잡은 날짜(TIME)
-- - 동사: 그룹화하다(GROUP BY), 정렬하다(ORDER BY)

-- [ 엣지케이스 검증 ]
-- - 단, 잡은 물고기의 길이가 10cm 이하일 경우에는 LENGTH 가 NULL 이며, LENGTH 에 NULL 만 있는 경우는 없습니다.
-- - => 실질적으로 NULL 값이 있는게 아니라 10cm 이하인경우 표시가 NULL 인거므로 물고기는 잡은걸로 인식할 수 있음.

-- [ 문제 ]
-- 월별 잡은 물고기의 수와 월을 출력하는 SQL문을 작성해주세요.
-- => '월별'로 GROUP BY

-- 잡은 물고기 수 컬럼명은 FISH_COUNT, 월 컬럼명은 MONTH로 해주세요.
-- 결과는 월을 기준으로 오름차순 정렬해주세요.
-- => ORDER BY MONTH ASC;

-- 단, 월은 숫자형태 (1~12) 로 출력하며 9 이하의 숫자는 두 자리로 출력하지 않습니다. 잡은 물고기가 없는 월은 출력하지 않습니다.
-- => MONTH(TIME) 메서드 사용

-- FISH_INFO: 잡은 물고기들의 정보를 담은 테이블

-- [ 요약 ]
-- 월별로 그룹화하여(GROUP BY MONTH(TIME)) 수와(COUNT(ID) 월을(MONTH(TIME))) 월 기준으로 오름차순 정렬하여 출력하는 문제

-- [ 풀이 ]
SELECT COUNT(ID) AS FISH_COUNT,
       MONTH(TIME) AS MONTH
FROM FISH_INFO
GROUP BY MONTH(TIME)
ORDER BY MONTH(TIME) ASC;