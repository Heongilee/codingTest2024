SELECT
        B.INGREDIENT_TYPE
      , SUM(A.TOTAL_ORDER) AS TOTAL_ORDER
FROM    FIRST_HALF      A
      , ICECREAM_INFO   B
WHERE   1=1
AND     A.FLAVOR    = B.FLAVOR
GROUP BY
        B.INGREDIENT_TYPE
ORDER BY
        SUM(A.TOTAL_ORDER) ASC
;