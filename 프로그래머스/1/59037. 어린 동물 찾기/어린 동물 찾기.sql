# 아이디와 이름을 조회
SELECT ANIMAL_ID ,	NAME
# 동물 보호소에 들어온 동물 중
from ANIMAL_INS
# 젊은 동물
where INTAKE_CONDITION != "Aged"