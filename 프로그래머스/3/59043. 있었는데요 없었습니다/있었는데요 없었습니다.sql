-- ANIMAL_INS: 동물 보호소에 들어온 동물의 정보를 담은 테이블
-- ANIMAL_OUTS: 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블

-- 관리자의 실수로 일부 동물의 입양일이 잘못 입력되었습니다. (ANIMAL_OUTS)
-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문을 작성해주세요.
-- => ANIMAL_INS.DATETIME > ANIMAL_OUTS.DATETIME

-- 보호 시작일이 빠른 순으로 조회해야 함

SELECT
    AO.ANIMAL_ID,
    AO.NAME
FROM
    ANIMAL_OUTS AS AO
JOIN
    ANIMAL_INS AS AI ON AO.ANIMAL_ID = AI.ANIMAL_ID
WHERE
    AO.DATETIME < AI.DATETIME
ORDER BY
    AI.DATETIME;