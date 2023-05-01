SELECT o.ANIMAL_ID, o.NAME FROM ANIMAL_OUTS AS o
LEFT JOIN (SELECT ANIMAL_ID, NAME FROM ANIMAL_INS) AS i
ON o.ANIMAL_ID = i.ANIMAL_ID
WHERE i.ANIMAL_ID IS NULL
ORDER BY ANIMAL_ID, NAME;