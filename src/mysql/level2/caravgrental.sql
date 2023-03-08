INSERT CAR_RENTAL_COMPANY_RENTAL_HISTORY (HISTORY_ID, CAR_ID, START_DATE, END_DATE)
VALUES (1, 1, '2022-09-27', '2022-10-01'),
       (2, 1, '2022-10-03', '2022-11-04'),
       (3, 2, '2022-09-05', '2022-09-05'),
       (4, 2, '2022-09-08', '2022-09-10'),
       (5, 3, '2022-09-16', '2022-10-15'),
       (6, 1, '2022-11-07', '2022-12-06');

-- WHERE 절에서 집계 함수 사용 불가능하므로 GROUP BY 후 HAVING 절을 사용하여 그룹화된 데이터에 대해 집계함수를 통한 조건절을 추가
SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE, START_DATE) + 1), 1) AS AVERAGE_DURATION FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
HAVING AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC;