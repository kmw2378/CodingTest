SELECT 
    t.APNT_NO,
    t.PT_NAME,
    t.PT_NO,
    t.MCDP_CD, 
    d.DR_NAME,
    t.APNT_YMD
    FROM (
        SELECT 
            a.APNT_NO,
            p.PT_NAME,
            p.PT_NO,
            a.MCDP_CD,
            a.MDDR_ID,
            a.APNT_YMD
        FROM APPOINTMENT a
        INNER JOIN PATIENT p ON 
            a.PT_NO = p.PT_NO
        WHERE 
            a.APNT_CNCL_YN = 'N' AND
            a.MCDP_CD = 'CS' AND
            DATE_FORMAT(a.APNT_YMD, '%Y-%m-%d') = '2022-04-13'
    ) AS t
LEFT JOIN DOCTOR d ON
    t.MDDR_ID = d.DR_ID
ORDER BY APNT_YMD;
