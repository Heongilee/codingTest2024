SELECT
        X.FOOD_TYPE
      , MAX(X.REST_ID)      AS REST_ID
      , MAX(X.REST_NAME)    AS REST_NAME
      , MAX(X.FAVORITES)    AS FAVORITES
FROM    (
            SELECT
                    T.*
                  , (
                      SELECT
                              MAX(U.FAVORITES)
                      FROM    REST_INFO   U
                      WHERE   1=1
                      AND     U.FOOD_TYPE = T.FOOD_TYPE
                      GROUP BY
                              U.FOOD_TYPE
                    ) AS MAX_FAVORITES
            FROM    REST_INFO   T
            WHERE   1=1
        )   X
WHERE   1=1
AND     X.FAVORITES = X.MAX_FAVORITES
GROUP BY
        FOOD_TYPE
ORDER BY
        FOOD_TYPE DESC
;