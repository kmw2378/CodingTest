SELECT c.CART_ID FROM (
    SELECT CART_ID FROM CART_PRODUCTS 
    WHERE NAME = 'Milk') AS temp
LEFT JOIN CART_PRODUCTS c ON c.CART_ID = temp.CART_ID
WHERE NAME = 'Yogurt';
