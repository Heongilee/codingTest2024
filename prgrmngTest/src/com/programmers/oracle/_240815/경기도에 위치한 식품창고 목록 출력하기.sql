SELECT
        T.WAREHOUSE_ID
      , T.WAREHOUSE_NAME
      , T.ADDRESS
      , NVL(T.FREEZER_YN, 'N') AS FREEZER_YN
FROM    FOOD_WAREHOUSE  T
WHERE   1=1
AND     T.ADDRESS   LIKE '경기도%'
ORDER BY
        T.WAREHOUSE_ID
;