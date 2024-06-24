SELECT
        DISTINCT
        CITY
FROM    STATION
WHERE   1=1
AND     SUBSTR(CITY, -1, 1) IN ('a', 'e', 'i', 'o', 'u')
;