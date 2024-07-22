SELECT
        A.FLAVOR
FROM    FIRST_HALF      A
      , ICECREAM_INFO   B
WHERE   1=1
AND     A.FLAVOR            = B.FLAVOR
AND     A.TOTAL_ORDER       > 3000
AND     B.INGREDIENT_TYPE   = 'fruit_based'
;
