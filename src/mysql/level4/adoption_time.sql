SELECT 
    n AS HOUR,
    IFNULL(COUNT, 0) AS COUNT
    FROM
    (SELECT 
        @N := @N + 1 AS n
        FROM ANIMAL_OUTS, 
        (SELECT 
            @N := - 1 
            FROM DUAL
        ) AS NN LIMIT 24
    ) AS T
LEFT JOIN (
    SELECT 
        HOUR(DATETIME) AS HOUR,
        COUNT(*) AS COUNT
        FROM ANIMAL_OUTS
        GROUP BY HOUR
        ORDER BY HOUR
) AS a ON T.n = a.HOUR;
