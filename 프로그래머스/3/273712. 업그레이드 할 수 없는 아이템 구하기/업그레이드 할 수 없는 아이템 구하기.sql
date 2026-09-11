# [ 문제 ]

-- - ITEM_INFO: 아이템 정보를 담은 테이블 (PK: ITEM_ID)
-- - ITEM_TREE: 아이템 관계를 나타내는 테이블 (PK: ITEM_ID)

-- - 더 이상 업그레이드할 수 없는 아이템의 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME), 아이템의 희귀도(RARITY)를 출력하는 SQL 문을 작성해 주세요. 이때 결과는 아이템 ID를 기준으로 내림차순 정렬해 주세요.

-- - 입출력 에로 
-- - (1). 'ITEM A' => 'ITEM B & C'
-- - (2). 'ITEM B' => 'ITEM D & E'
-- - (3). 'ITEM_C', 'ITEM_D', 'ITEM_E는 업그레이드 불가능

-- - 즉
-- - 'PARENT_ITEM_ID' 에 I.ITEM_ID 가 존재하면 업그레이드가 가능한 상태인건고
-- - ID 값이 존재하지 않으면 (NULL이면) 업그레이드가 불가능한 상태


# [ 메모리 멘탈 모델 ]

-- '더 이상 업그레이드할 수 없는 아이템' 을 구하는게 목적 
-- PARENT_ITEM_ID 에 없는 I.ITEM_ID 값을 추출해야 하므로

-- - 1. ITEM_INFO 테이블을 기준으로 두 테이블을 LEFT JOIN (ON I.ITEM_ID = T.PARENT_ITEM_ID => 어떤 ITEM_ID 에 PARENT_ITEM_ID 가 없는지 확인하는게 핵심이므로)
-- - 2. 조인을 진행하면 입출력 예시로 보았을때 ITEM_ID 가 0과 1인 값을 제외하고 나머지 행에 PARENT_ITEM_ID 값은 값이 존재하지 않음(NULL) 로 채워지게 됨.
-- - 3. WHERE 절에 NULL 인 값만 필터링 해서 가져옴
-- - 4. 정렬


# [ 풀이 ]

SELECT I.ITEM_ID,
       I.ITEM_NAME,
       I.RARITY
FROM ITEM_INFO AS I
LEFT JOIN ITEM_TREE AS T ON I.ITEM_ID = T.PARENT_ITEM_ID
WHERE T.PARENT_ITEM_ID IS NULL
ORDER BY I.ITEM_ID DESC;