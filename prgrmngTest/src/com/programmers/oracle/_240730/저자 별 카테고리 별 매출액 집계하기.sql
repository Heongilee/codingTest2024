/*********************************************************
 * 2. 결과 출력
 *  2.1. T1과 T2를 조인해 책의 판매량 데이터도 가져올 수 있도록 함
 *  2.2. AUTHOR테이블에서 저자명만 필요하므로 스칼라 서브쿼리로 조회
 *  2.3. 저자+카테고리로 GROUP BY해서 매출액을 계산
 *********************************************************/
SELECT
        T1.AUTHOR_ID
      , (
            SELECT  AUTHOR_NAME
            FROM    AUTHOR A
            WHERE   1=1
            AND     T1.AUTHOR_ID    = A.AUTHOR_ID
        )   AS      AUTHOR_NAME
      , T1.CATEGORY
      , SUM(T2.SELL_QTY * T1.PRICE) AS TOTAL_SALES
FROM    BOOK    T1
      , (
            /*********************************************************
             * 1. 2022년 1월의 도서별 판매량을 집계
             *********************************************************/
            SELECT
                    T.BOOK_ID
                  , SUM(T.SALES) AS SELL_QTY
            FROM    BOOK_SALES T
            WHERE   1=1
            AND     TO_CHAR(T.SALES_DATE, 'YYYYMM') = '202201'
            GROUP BY
                    T.BOOK_ID
        )   T2
WHERE   1=1
AND     T1.BOOK_ID  = T2.BOOK_ID
GROUP BY
        T1.AUTHOR_ID
      , T1.CATEGORY
ORDER BY
        T1.AUTHOR_ID    ASC
      , T1.CATEGORY     DESC
;