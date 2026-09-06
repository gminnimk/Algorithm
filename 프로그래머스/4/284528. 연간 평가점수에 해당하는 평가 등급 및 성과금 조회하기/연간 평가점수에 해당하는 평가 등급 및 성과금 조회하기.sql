# [ 문제 ]

-- - HR_DEPARTMENT: 회사의 부서 정보를 담은 테이블 (PK: DEPT_ID)
-- - HR_EMPLOYEES: 회사의 사원 정보를 담은 테이블 (PK: EMP_NO, FK: DEPT_ID)
-- - HR_GRADE: 2022년 사원의 평가 정보를 담은 테이블 (FK: EMP_NO)

-- - HR_DEPARTMENT, HR_EMPLOYEES, HR_GRADE 테이블을 이용해 사원별 성과금 정보를 조회하려합니다. 평가 점수별 등급과 등급에 따른 성과금 정보가 아래와 같을 때, 사번, 성명, 평가 등급, 성과금을 조회하는 SQL문을 작성해주세요.


# 기준 점수	평가 등급	성과금(연봉 기준)
# 96 이상	    S	    20%
# 90 이상	    A	    15%
# 80 이상	    B	    10%
# 이외	    C	    0%

-- - 평가등급의 컬럼명은 GRADE로, 성과금의 컬럼명은 BONUS로 해주세요.
-- - 결과는 사번 기준으로 오름차순 정렬해주세요.


# [ 메모리 멘탈 모델 ]

-- - 1. 사원과 그에 따른 평가 정보의 정보를 알아야 하므로 HR_EMPLOYEES와 HR_GRADE 를 EMP_NO 키를 ON 으로 INNER JOIN => 조인하기전에 상반기와 하반기 데이터로 나눠져 있어서 미리 계산 처리르 해서 가져와야할지

-- 1-1. 상, 하반기 둘다 계산을한건지 (평균값)? 
-- 1-2. 상, 하반기 중 제일 큰 평가 점수만 계산한건지? 
-- => 이에 대한 내용은 입출력 예로 직접 찾아봐야 할 거 같음
-- => 정호식씨를 보았을떄 92점과 84점 존재, 기존 연봉 65000000
-- 1-1의 경우에서는 총 176점이고 이를 평균 내면 88점 이므로 GRADE 는 B로 결과가 나오게 되고, 성과급은 10% 지급이므로 6500000 

-- 따라서 문제에서 의도한 바는 직원별 상.하반기 모든 평가 정보에 대해 평균값을 도출하여 최종적인 정보를 도출하게 하는게 목적.

-- 그렇다면 실제 평가 정보 테이블을 조인하기전에 미리 집계 및 계산을 해두는게 오류 리스크를 없앨 수 있지 않을까?

# [ 최종 메모리 멘탈 모델 ]

-- - 1. HR_GRADE 테이블에 대해서 EMP_NO 집게 및 EMP_NO 별 SCORE 점수 평균 값 도출
-- - 2. HR_EMPLOYEES 테이블과 EMP_NO 기준으로 INNER JOIN 하여 테이블 병합
-- - 3. 사원 별 상,하반기 평가 점수 평균값 SCORE 값에 따라 CASE ~ 구문을 활용하여 GRADE 값과 BONUS 값을 도출하도록 구축
-- - 3. 사번 기준 오름차순 정렬.


# [ 풀이 ]
SELECT E.EMP_NO,
       E.EMP_NAME,
       CASE
           WHEN G.SCORE >= 96 THEN 'S'
           WHEN G.SCORE >= 90 THEN 'A'
           WHEN G.SCORE >= 80 THEN 'B'
           ELSE 'C'
       END AS GRADE,
       CASE
           WHEN G.SCORE >= 96 THEN E.SAL * 0.2
           WHEN G.SCORE >= 90 THEN E.SAL * 0.15
           WHEN G.SCORE >= 80 THEN E.SAL * 0.1
           ELSE 0
       END AS BONUS
FROM HR_EMPLOYEES AS E
INNER JOIN (
    -- 사원 평가 정보 테이블에서 상,하반기에 대한 평가 점수에 대해 사원 별 평균값 도출
    SELECT EMP_NO, AVG(SCORE) AS SCORE
    FROM HR_GRADE
    GROUP BY EMP_NO
) AS G ON E.EMP_NO = G.EMP_NO
-- 그룹화는 이미 EMP_NO 가 고유하기에 할 필요 X
-- 사번 기준 오름차순 정렬
ORDER BY E.EMP_NO ASC;