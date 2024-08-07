/************************************************************
 * LIKE 검색이 성능이 좋지 않을 수 있음
 ************************************************************/
SELECT
        T.CAR_TYPE
      , COUNT(
          CASE
              WHEN T.OPTIONS LIKE '%통풍시트%'
                  THEN T.CAR_ID
              WHEN T.OPTIONS LIKE '%열선시트%'
                  THEN T.CAR_ID
              WHEN T.OPTIONS LIKE '%가죽시트%'
                  THEN T.CAR_ID
          END
        ) AS CARS
FROM    CAR_RENTAL_COMPANY_CAR T
WHERE   1=1
GROUP BY
        CAR_TYPE
ORDER BY
        CAR_TYPE
;

/************************************************************
 * 다르게 풀어봤는데 이건 아예 타임아웃이네...?
 ************************************************************/
SELECT  V.CAR_TYPE
      , COUNT(
          CASE
              WHEN V.OPTIONS IN ('통풍시트', '열선시트', '가죽시트')
                  THEN V.CAR_ID
          END
        ) AS CARS
FROM    (
            SELECT  DISTINCT
                    U.CAR_ID
                  , U.CAR_TYPE
                  , TRIM(REGEXP_SUBSTR(U.OPTIONS, '[^,]+', 1, LEVEL)) OPTIONS
            FROM    DUAL   D
                  , (
                      SELECT    T.*
                              , 'X' AS DUMMY
                      FROM      CAR_RENTAL_COMPANY_CAR  T
                      WHERE     1=1
                    ) U
            WHERE   1=1
            AND     D.DUMMY = U.DUMMY
            CONNECT BY LEVEL <= REGEXP_COUNT(U.OPTIONS,',') + 1
        )   V
WHERE   1=1
GROUP BY
        CAR_TYPE
ORDER BY
        CAR_TYPE
;