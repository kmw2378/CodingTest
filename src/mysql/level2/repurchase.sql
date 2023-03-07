-- 테이블 생성
CREATE TABLE ONLINE_SALE (
    ONLINE_SALE_ID INTEGER NOT NULL,
    USER_ID INTEGER NOT NULL,
    PRODUCT_ID INTEGER NOT NULL,
    SALES_AMOUNT INTEGER NOT NULL,
    SALES_DATE DATE NOT NULL
);

-- 테이블에 행 추가
INSERT ONLINE_SALE (ONLINE_SALE_ID, USER_ID, PRODUCT_ID, SALES_AMOUNT, SALES_DATE)
VALUES (1, 1, 3, 2, '2022-02-25'),
       (2, 1, 4, 1, '2022-03-01'),
       (4, 2, 4, 2, '2022-03-12'),
       (3, 1, 3, 3, '2022-03-31'),
       (5, 3, 5, 1, '2022-04-03'),
       (6, 2, 4, 1, '2022-04-06'),
       (2, 1, 4, 2, '2022-05-11');

-- USER_ID, PRODUCT_ID 를 기준으로 GROUP BY 후 각각 행에서 SALES_DATE 의 개수가 1보다 큰 경우를 조건으로 사용
SELECT USER_ID, PRODUCT_ID FROM ONLINE_SALE
    GROUP BY USER_ID, PRODUCT_ID
    HAVING COUNT(SALES_DATE) > 1
    ORDER BY USER_ID, PRODUCT_ID DESC;