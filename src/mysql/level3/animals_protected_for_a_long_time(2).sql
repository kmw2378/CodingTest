SELECT i.ANIMAL_ID, i.NAME FROM ANIMAL_INS AS i
JOIN (SELECT ANIMAL_ID, DATETIME FROM ANIMAL_OUTS) AS o
ON i.ANIMAL_ID = o.ANIMAL_ID
ORDER BY DATEDIFF(i.DATETIME, o.DATETIME)
LIMIT 2;
