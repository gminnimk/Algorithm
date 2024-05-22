-- USER_INFO 테이블에서 나이(AGE)가 NULL인 사용자 수를 계산

SELECT COUNT(*) AS USER  -- 사용자 수를 USER라는 이름으로 반환
FROM USER_INFO           -- USER_INFO 테이블에서
WHERE AGE IS NULL        -- AGE(나이)가 NULL인 행을 찾음.