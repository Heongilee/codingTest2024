SELECT
        T.USER_ID
      , (
          SELECT A.NICKNAME
          FROM  USED_GOODS_USER A
          WHERE 1=1
          AND   A.USER_ID  = T.USER_ID
        ) AS NICKNAME
      , T.TOTAL_SALES
FROM    (
            SELECT
                    A.WRITER_ID AS USER_ID
                  , SUM(
                      CASE
                          WHEN A.STATUS = 'DONE'
                              THEN A.PRICE
                          ELSE 0
                      END
                    ) AS TOTAL_SALES
            FROM    USED_GOODS_BOARD    A
            GROUP BY
                    A.WRITER_ID
        )  T
WHERE   1=1
AND     T.TOTAL_SALES   >= 700000
ORDER BY
        T.TOTAL_SALES
;