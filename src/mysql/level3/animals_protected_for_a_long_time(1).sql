SELECT i.NAME, i.DATETIME FROM ANIMAL_INS AS i
LEFT JOIN (SELECT ANIMAL_ID FROM ANIMAL_OUTS) AS o
ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE o.ANIMAL_ID IS NULL
ORDER BY DATETIME
LIMIT 3;
