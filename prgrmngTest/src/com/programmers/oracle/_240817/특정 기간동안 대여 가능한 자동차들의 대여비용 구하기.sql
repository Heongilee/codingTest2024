SELECT
        T.CAR_ID
      , T.CAR_TYPE
      , TO_NUMBER(T.FEE) AS FEE
FROM    (
            SELECT
                    A.CAR_ID
                  , A.CAR_TYPE
                  , (
                        SELECT
                                (A.DAILY_FEE * (100 - C.DISCOUNT_RATE) / 100) * 30 AS FEE
                        FROM    CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
                        WHERE   1=1
                        AND     A.CAR_TYPE      = C.CAR_TYPE
                        AND     C.DURATION_TYPE = '30일 이상'
                        AND     ROWNUM = 1
                    )   AS      FEE
            FROM    CAR_RENTAL_COMPANY_CAR A
            WHERE   1=1
            AND     A.CAR_TYPE   IN ('세단', 'SUV')
        )   T
WHERE   1=1
AND     NOT EXISTS (
            SELECT  1
            FROM    CAR_RENTAL_COMPANY_RENTAL_HISTORY B
            WHERE   1=1
            AND     T.CAR_ID                           = B.CAR_ID
            AND     TO_CHAR(B.START_DATE, 'YYYYMMDD')  <= '20221130'
            AND     TO_CHAR(B.END_DATE, 'YYYYMMDD')    >= '20221101'
        )
AND     T.FEE >= 500000
AND     T.FEE <  2000000
ORDER BY
        T.FEE       DESC
      , T.CAR_TYPE  ASC
      , T.CAR_ID    DESC
;