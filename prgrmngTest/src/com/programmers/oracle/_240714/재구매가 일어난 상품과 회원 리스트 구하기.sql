SELECT
        DISTINCT
        USER_ID
      , PRODUCT_ID
FROM    ONLINE_SALE A
WHERE   1=1
AND     EXISTS (
            SELECT  1
            FROM    ONLINE_SALE B
            WHERE   1=1
            AND     A.USER_ID        =  B.USER_ID
            AND     A.PRODUCT_ID     =  B.PRODUCT_ID
            AND     A.ONLINE_SALE_ID <> B.ONLINE_SALE_ID
        )
ORDER BY
        USER_ID
      , PRODUCT_ID DESC
;