SELECT USER_ID, NICKNAME, SUM(PRICE) AS TOTAL_SALES FROM USED_GOODS_BOARD ugb
JOIN USED_GOODS_USER ugu on ugu.USER_ID = ugb.WRITER_ID
WHERE STATUS = 'DONE'
GROUP BY USER_ID
HAVING TOTAL_SALES >= 700000
ORDER BY TOTAL_SALES;