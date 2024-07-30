/************************************************************************
 * 내가 푼 쿼리
 ************************************************************************/
SELECT
        T.*
FROM    (
            SELECT
                    A.PRODUCT_ID
                  , A.PRODUCT_NAME
                  , A.PRODUCT_CD
                  , A.CATEGORY
                  , A.PRICE
            FROM    FOOD_PRODUCT A
            WHERE   1=1
            ORDER BY
                    A.PRICE DESC
        )  T
WHERE   1=1
AND     ROWNUM = 1
;

/************************************************************************
 * 답안
 ************************************************************************/
SELECT
        A.PRODUCT_ID
      , A.PRODUCT_NAME
      , A.PRODUCT_CD
      , A.CATEGORY
      , A.PRICE
FROM    FOOD_PRODUCT A
WHERE   1=1
AND     A.PRICE = (
            SELECT  MAX(PRICE)
            FROM    FOOD_PRODUCT
            WHERE   1=1
        )
;