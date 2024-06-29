SELECT
        DISTINCT
        CITY
FROM    STATION
WHERE   1=1
AND     SUBSTR(CITY, 0, 1)  NOT IN ('A', 'E', 'I', 'O', 'U')
AND     SUBSTR(CITY, -1, 1) NOT IN ('a', 'e', 'i', 'o', 'u')
;
