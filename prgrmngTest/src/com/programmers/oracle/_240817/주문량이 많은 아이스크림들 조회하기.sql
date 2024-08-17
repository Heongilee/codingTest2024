SELECT
        U.FLAVOR
FROM    (
            SELECT
                    T.FLAVOR
                  , SUM(T.TOTAL_ORDER)  AS TOTAL_ORDER
            FROM    (
                        SELECT
                                FLAVOR
                              , TOTAL_ORDER
                        FROM    FIRST_HALF
                        UNION ALL
                        SELECT
                                FLAVOR
                              , TOTAL_ORDER
                        FROM    JULY
                    )  T
            WHERE   1=1
            GROUP BY
                    T.FLAVOR
            ORDER BY
                    TOTAL_ORDER DESC
        )  U
WHERE   1=1
AND     ROWNUM <= 3
;