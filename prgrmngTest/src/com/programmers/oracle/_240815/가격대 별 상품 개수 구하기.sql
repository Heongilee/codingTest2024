SELECT
        T.PRICE_GROUP   AS PRICE_GROUP
      , COUNT(1)        AS PRODUCTS
FROM    (
            SELECT
                    PRODUCT_ID
                  , PRODUCT_CODE
                  , PRICE
                  , FLOOR(PRICE / 10000) * 10000 AS PRICE_GROUP
            FROM    PRODUCT
        )  T
WHERE   1=1
GROUP BY
        T.PRICE_GROUP
ORDER BY
        T.PRICE_GROUP
;