# [ 문제 ]

-- - ANIMAL_INS: 동물 보호소에 들어온 동물의 정보를 담은 테이블

-- - 입양 게시판에 동물 정보를 게시하려 합니다. 동물의 생물 종, 이름, 성별 및 중성화 여부를 아이디 순으로 조회하는 SQL문을 작성해주세요. 이때 프로그래밍을 모르는 사람들은 NULL이라는 기호를 모르기 때문에, 이름이 없는 동물의 이름은 "No name"으로 표시해 주세요.


# [ 메모리 멘탈 모델 ]

-- - 1. 테이블을 FROM 절로 가져온다.
-- - 2. SELECT 절에서 필요 컬럼들을 가져온다.
-- - 3. 'NAME' 컬럼의 값이 NULL 일 경우 'No name' 으로 처리한다. => IFNULL 함수 사용
-- - 4. 아이디 순으로 ORDER BY 정렬.

SELECT ANIMAL_TYPE,
       IFNULL(NAME, 'No name') AS NAME,
       SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC;