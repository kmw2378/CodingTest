-- UNION ALL 사용
-- WHERE 절 중복 사용 제거
-- 서브쿼리 절에 반드시 Alias 를 포함해야 하므로 TOTAL_SALE 문구 추가
SELECT * FROM (
                  SELECT
                      DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE
                       , PRODUCT_ID
                       , USER_ID
                       , SALES_AMOUNT FROM ONLINE_SALE
                  UNION ALL
                  SELECT
                      DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE
                       , PRODUCT_ID
                       , NULL
                       , SALES_AMOUNT FROM OFFLINE_SALE
              ) TOTAL_SALE
WHERE SALES_DATE BETWEEN '2022-03-01' AND '2022-03-31'
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID;