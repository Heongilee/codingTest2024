/*****************************************************************
 * 2. 결과 쿼리 출력
 *  2.1. T1과 T2를 조인하면 1에 해당되는 CAR_ID들의 모든 이력이 나옴
 *  2.2. 월별, 자동차별 대여횟수가 0이었던 기록에 대해선 제외
 *  2.3. 모든 이력중에서 다시 2022년 08월 ~ 2022년 10월 사이의 결과로 필터
 *  2.4. 정렬
 *****************************************************************/
SELECT
        TO_CHAR(T2.START_DATE, 'FMMM') AS MONTH
      , T2.CAR_ID
      , COUNT(1)                       AS RECORDS
FROM    (
            /*****************************************************************
             * 1. 2022년 08월 ~ 2022년 10월까지 대여횟수가 5번이상인 CAR_ID를 찾음 (T1)
             *****************************************************************/
            SELECT
                    CAR_ID
            FROM    CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE   1=1
            AND     TO_CHAR(START_DATE, 'YYYYMM') BETWEEN '202208' AND '202210'
            GROUP BY
                    CAR_ID
            HAVING  1=1
            AND     COUNT(1) >= 5
        )   T1
      , CAR_RENTAL_COMPANY_RENTAL_HISTORY   T2
WHERE   1=1
AND     T1.CAR_ID   = T2.CAR_ID
GROUP BY
        TO_CHAR(T2.START_DATE, 'FMMM')
      , T2.CAR_ID
HAVING  1=1
AND     COUNT(1)                        <> 0
AND     TO_CHAR(T2.START_DATE, 'FMMM')  BETWEEN 8 AND 10
ORDER BY
        TO_NUMBER(TO_CHAR(T2.START_DATE, 'FMMM'))   ASC
      , T2.CAR_ID                                   DESC
;