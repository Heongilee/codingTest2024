SELECT  T.*
FROM    (
            SELECT
                    CITY
                  , LENGTH(CITY) AS LEN
            FROM    STATION
            WHERE   1=1
            ORDER BY
                    LEN
                  , CITY
        )   T
WHERE   ROWNUM = 1
UNION ALL
SELECT  T.*
FROM    (
            SELECT
                    CITY
                  , LENGTH(CITY) AS LEN
            FROM    STATION
            WHERE   1=1
            ORDER BY
                    LEN DESC
                  , CITY
        )   T
WHERE   ROWNUM = 1
;
