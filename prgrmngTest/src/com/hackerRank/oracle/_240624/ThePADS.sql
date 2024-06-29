SELECT
           T.NM
FROM       (
                SELECT
                        NAME || '(' || SUBSTR(OCCUPATION, 0, 1) || ')' AS NM
                FROM    OCCUPATIONS
                ORDER BY
                        NAME
                      , SUBSTR(OCCUPATION, 0, 1)
           )    T
UNION ALL
SELECT
           'There are a total of ' || T.CNT || ' ' || LOWER(T.OCC) || 's.'
FROM       (
                SELECT
                        LOWER(OCCUPATION) AS OCC
                      , COUNT(1) AS CNT
                FROM    OCCUPATIONS
                GROUP BY
                        OCCUPATION
                ORDER BY
                        COUNT(1)
                      , LOWER(OCCUPATION)
           )    T
;