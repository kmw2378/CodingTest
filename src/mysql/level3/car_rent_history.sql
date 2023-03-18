SELECT c.CAR_ID FROM CAR_RENTAL_COMPANY_CAR c
                         JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY h ON c.CAR_ID = h.CAR_ID
WHERE c.CAR_TYPE = '세단' and START_DATE between '2022-10-01' and '2022-10-31'
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;