# [ 문제 ]

-- - FISH_INFO: 잡은 물고기들의 정보를 담은 테이블 (PK: ID, FK: FISH_TYPE)
-- - FISH_NAME_INFO: 물고기의 이름에 대한 정보 테이블 (PK: FISH_TYPE)

-- - 물고기 종류 별로 가장 큰 물고기의 ID, 물고기 이름, 길이를 출력하는 SQL 문을 작성해주세요.
-- - 물고기의 ID 컬럼명은 ID, 이름 컬럼명은 FISH_NAME, 길이 컬럼명은 LENGTH로 해주세요.
-- - 결과는 물고기의 ID에 대해 오름차순 정렬해주세요.
-- - 단, 물고기 종류별 가장 큰 물고기는 1마리만 있으며 10cm 이하의 물고기가 가장 큰 경우는 없습니다.


# [ 메모리 멘탈 모델 ]

-- - 1. 두 테이블을 FISH_TYPE 키 기준으로 INNER JOIN을 한다. 
-- - 2. '물고기 종류 별로 가장 큰 물고기의 ID, 이름, 길이'
-- => FISH_TYPE 으로 그룹화를 진행하여 MAX() 집계함수를 사용하면 TYPE 별 가장 큰 길이의 행을 구할 수 있으나 ID는 내부 엔진에서 임의의 값으로 가져오는 문제가 발생할 수 있음.
-- => ID까지 정확하게 매핑되는 행을 가져오기 위해서는 WHERE 조건절에 서브쿼리를 활용.
-- - 3. 정렬

SELECT I.ID,
       N.FISH_NAME,
       I.LENGTH
FROM FISH_INFO AS I
INNER JOIN FISH_NAME_INFO AS N ON I.FISH_TYPE = N.FISH_TYPE
WHERE (I.FISH_TYPE, I.LENGTH) IN (
    SELECT FISH_TYPE, MAX(LENGTH)
    FROM FISH_INFO
    GROUP BY FISH_TYPE
)
ORDER BY I.ID ASC;