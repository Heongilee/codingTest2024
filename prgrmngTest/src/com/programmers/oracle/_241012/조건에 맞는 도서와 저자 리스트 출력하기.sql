SELECT  B.BOOK_ID
      , (
          SELECT  A.AUTHOR_NAME
          FROM    AUTHOR A
          WHERE   1=1
          AND     A.AUTHOR_ID   = B.AUTHOR_ID
        ) AS      AUTHOR_NAME
      , TO_CHAR(B.PUBLISHED_DATE, 'YYYY-MM-DD') AS PUBLISHED_DATE
FROM    BOOK    B
WHERE   1=1
AND     B.CATEGORY  = '경제'
ORDER BY
        B.PUBLISHED_DATE