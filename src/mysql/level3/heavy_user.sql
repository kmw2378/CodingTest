-- 서브쿼리를 사용한 풀이
SELECT ID, NAME, HOST_ID FROM PLACES
WHERE HOST_ID IN (
    SELECT HOST_ID FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(HOST_ID) > 1
    );

-- 조인을 사용한 풀이
SELECT p.ID, p.NAME, p.HOST_ID FROM PLACES p
JOIN (
    SELECT * FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(*) > 1
    ) h
    ON p.HOST_ID = h.HOST_ID;
