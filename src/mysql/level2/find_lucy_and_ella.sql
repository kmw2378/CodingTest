SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE FROM ANIMAL_INS
WHERE NAME REGEXP "^(Lucy|Ella|Pickle|Rogan|Sabrina|Mitty)$"
ORDER BY ANIMAL_ID;

-- 이건 정규식 검색의 특징 떄문입니다.
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME REGEXP 'ucy|Ella|Pickle|Rogan|Sabrina|Mitty'
ORDER BY ANIMAL_ID
-- 만약 이 코드를 실행시켜보면 ucy여서 Lucy가 검색이 안될 것 같지만 잘 됩니다.
-- REGEXP는 문자열 내부에 어떤 부분이든 해당 정규식이 존재한다면 True 입니다.
-- 따라서 i'm not Lucy 라는 이름을 가진 동물이 있다면 위의 식에서는 통과를 해 버립니다.
-- 만약 정규식으로 통과하고 싶으시다면
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE 
FROM ANIMAL_INS 
WHERE NAME regexp "^(Lucy|Ella|Pickle|Rogan|Sabrina|Mitty)$"
ORDER BY ANIMAL_ID
-- 이렇게 시작과 끝 역시도 표시해 줘야 합니다.
