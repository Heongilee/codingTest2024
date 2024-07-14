SELECT
        TO_CHAR(SALES_DATE, 'YYYY-MM-DD')   AS SALES_DATE
      , PRODUCT_ID
      , USER_ID
      , SALES_AMOUNT
FROM    (
            SELECT
                    USER_ID
                  , PRODUCT_ID
                  , SALES_AMOUNT
                  , SALES_DATE
            FROM    ONLINE_SALE
            WHERE   1=1
            AND     TO_CHAR(SALES_DATE, 'YYYY-MM') = '2022-03'

            UNION ALL

            SELECT
                    NULL               AS USER_ID
                  , PRODUCT_ID
                  , SALES_AMOUNT
                  , SALES_DATE
            FROM    OFFLINE_SALE
            WHERE   1=1
            AND     TO_CHAR(SALES_DATE, 'YYYY-MM') = '2022-03'
        )   T
WHERE   1=1
ORDER BY
        T.SALES_DATE
      , T.PRODUCT_ID
      , T.USER_ID
;