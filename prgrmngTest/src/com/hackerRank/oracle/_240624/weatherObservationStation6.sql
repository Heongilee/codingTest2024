SELECT
        DISTINCT
        CITY
FROM    STATION
WHERE   1=1
AND     SUBSTR(CITY, 0, 1) IN ('A', 'E', 'I', 'O', 'U')
;