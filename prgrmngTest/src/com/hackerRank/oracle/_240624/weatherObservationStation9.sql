SELECT
        DISTINCT
        CITY
FROM    STATION
WHERE   1=1
AND     SUBSTR(CITY, 0, 1) NOT IN ('A', 'E', 'I', 'O', 'U')
;
