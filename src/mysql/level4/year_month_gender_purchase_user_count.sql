SELECT 
    YEAR(SALES_DATE) AS YEAR,
    MONTH(SALES_DATE) AS MONTH,
    GENDER,
    COUNT(DISTINCT u.USER_ID) AS USERS
    FROM ONLINE_SALE s
LEFT JOIN USER_INFO u ON s.USER_ID = u.USER_ID
WHERE GENDER IS NOT NULL 
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER
