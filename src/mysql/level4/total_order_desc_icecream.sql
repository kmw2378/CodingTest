SELECT 
    FLAVOR 
    FROM (
    SELECT 
        fh.FLAVOR,
        fh.TOTAL_ORDER + j.TOTAL_ORDER AS TOTAL_ORDER
        FROM (
            SELECT 
                FLAVOR,
                SUM(TOTAL_ORDER) AS TOTAL_ORDER
            FROM FIRST_HALF
            GROUP BY FLAVOR
        ) AS fh
    JOIN (
        SELECT 
            FLAVOR,
            SUM(TOTAL_ORDER) AS TOTAL_ORDER
            FROM JULY
            GROUP BY FLAVOR
        ) AS j
    ON fh.FLAVOR = j.FLAVOR
    GROUP BY FLAVOR
    ORDER BY TOTAL_ORDER DESC
) total LIMIT 3
