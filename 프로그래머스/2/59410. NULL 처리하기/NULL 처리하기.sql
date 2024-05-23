SELECT ANIMAL_TYPE, IFNULL(NAME,'No name') AS NAME, SEX_UPON_INTAKE
-- SELECT: 데이터베이스에서 데이터를 조회할 때 사용하는 명령어
-- ANIMAL_TYPE: 조회할 열(컬럼) 중 하나로, 동물의 종류(예: 개, 고양이)
-- IFNULL(NAME, 'No name') AS NAME: 조회할 열 중 하나로, 이름(NAME) 열의 값 호출.
--    IFNULL 함수는 NAME 열의 값이 NULL(값이 없음)일 경우 'No name'이라는 문자열을 반환
--    AS NAME: 조회 결과에서 이 열의 이름을 NAME으로 지정
-- SEX_UPON_INTAKE: 조회할 열 중 하나로, 동물이 들어올 때의 성별 상태

FROM ANIMAL_INS
-- FROM: 데이터를 조회할 테이블을 지정
-- ANIMAL_INS: 조회할 데이터가 저장된 테이블의 이름