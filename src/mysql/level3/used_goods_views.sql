SELECT CONCAT('/home/grep/src/', ugb.BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT) AS FILE_PATH FROM USED_GOODS_BOARD ugb
JOIN USED_GOODS_FILE ugf on ugb.BOARD_ID = ugf.BOARD_ID
WHERE VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY FILE_ID DESC;