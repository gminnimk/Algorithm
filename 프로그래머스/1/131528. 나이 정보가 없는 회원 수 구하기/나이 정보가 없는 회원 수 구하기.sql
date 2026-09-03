# [ 문제 ]

-- - USER_INFO: 어느 의류 쇼핑몰에 가입한 회원 정보 테이블
-- - 'GENDER' 컬럼은 비어있거나 0 또는 1의 값을 가짐
-- -- 0인 경우 남자
-- -- 1인 경우 여자

-- - USER_INFO 테이블에서 나이 정보가 없는 회원이 몇 명인지 출력하는 SQL문을 작성해주세요. 이때 컬럼명은 USERS로 지정해주세요.


# [ 메모리 멘탈 모델 ]

-- - 1. FROM 절에 USER_INFO 테이블을 가져온다.
-- - 2. 나이 정보가 없는 회원을 가져오기 위해 WHERE 절 필터링에서 AGE 컬럼에 NULL 인 값을 조건으로 지정한다.
-- - 3. SELECT 절에서 COUNT 함수를 이용해 최종적으로 몇 명인지 출력한다.

SELECT COUNT(USER_ID) AS USERS
FROM USER_INFO
WHERE ISNULL(AGE)