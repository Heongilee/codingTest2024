SELECT
        A.MCDP_CD   AS "진료과코드"
      , COUNT(1)    AS "5월예약건수"
FROM    APPOINTMENT A
WHERE   1=1
AND     TO_CHAR(A.APNT_YMD, 'YYYYMM') = '202205'
GROUP BY
        A.MCDP_CD
ORDER BY
        COUNT(1)
      , A.MCDP_CD
;