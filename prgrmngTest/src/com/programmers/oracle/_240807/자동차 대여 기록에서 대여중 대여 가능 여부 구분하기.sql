SELECT
        T.CAR_ID
      , (
            CASE
                WHEN EXISTS (
                    SELECT  1
                    FROM    CAR_RENTAL_COMPANY_RENTAL_HISTORY U
                    WHERE   1=1
                    AND     U.CAR_ID                            = T.CAR_ID
                    AND     TO_CHAR(U.START_DATE, 'YYYYMMDD')   <= '20221016'
                    AND     TO_CHAR(U.END_DATE, 'YYYYMMDD')     >= '20221016'
                )
                    THEN '대여중'
                ELSE '대여 가능'
            END
        )   AS AVAILABILITY
FROM    CAR_RENTAL_COMPANY_RENTAL_HISTORY T
WHERE   1=1
GROUP BY
        CAR_ID
ORDER BY
        CAR_ID DESC
;