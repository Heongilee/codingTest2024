SELECT
        (
            SELECT  M.MEMBER_NAME
            FROM    MEMBER_PROFILE M
            WHERE   1=1
            AND     M.MEMBER_ID = PZ.MEMBER_ID
        )   AS      MEMBER_NAME
      , PZ.REVIEW_TEXT
      , TO_CHAR(PZ.REVIEW_DATE, 'YYYY-MM-DD') AS REVIEW_DATE
FROM    (
            SELECT
                    R.MEMBER_ID
                  , R.REVIEW_TEXT
                  , R.REVIEW_DATE
                  , COUNT(1) OVER(PARTITION BY R.MEMBER_ID) AS REVIEW_CNT_BY_MEMBER_ID
            FROM    REST_REVIEW R
            WHERE   1=1
        )   PZ
WHERE   1=1
AND     PZ.REVIEW_CNT_BY_MEMBER_ID = (
            SELECT  MAX(COUNT(1))
            FROM    REST_REVIEW T
            WHERE   1=1
            GROUP BY
                    T.MEMBER_ID
        )
ORDER BY
        PZ.REVIEW_DATE
      , PZ.REVIEW_TEXT
;