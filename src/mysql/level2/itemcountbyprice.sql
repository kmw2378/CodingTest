CREATE TABLE PRODUCT (
  PRODUCT_ID INTEGER NOT NULL,
  PRODUCT_CODE VARCHAR(8) NOT NULL,
  PRICE INTEGER NOT NULL
);

INSERT PRODUCT (PRODUCT_ID, PRODUCT_CODE, PRICE)
VALUES (1, 'A1000011', 10000),
       (2, 'A1000045', 9000),
       (3, 'C3000002', 22000),
       (4, 'C3000006', 15000),
       (5, 'C3000010', 30000),
       (6, 'K1000023', 17000);

-- DIV 함수를 사용하여 정수 나눗셈을 구현
-- 조회하려는 테이블에 alias를 줘서 임의의 컬럼값을 추가할 수 있도록 한다.
SELECT (PRICE DIV 10000 * 10000) AS PRICE_GROUP, COUNT(p.PRODUCT_ID) AS PRODUCTS FROM PRODUCT p
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP;