/******************************************************************
 * 3. 결과 출력
 *  3.1. MAX_PRICE는 1에서 이미 계산됐으므로 문법 오류를 피하기 위한 MAX 처리
 *  3.2. 상품의 가격과 카테고리에서 제일비싼 가격과 일치하는 데이터만 필터
 *  3.3. 카테고리 항목 IN절로 필터
 *  3.4. 카테고리별, 상품별로 그룹핑
 *  3.5. MAX_PRICE 기준 내림차순 정렬
 ******************************************************************/
SELECT
        Z.CATEGORY
      , MAX(Z.MAX_PRICE) AS MAX_PRICE
      , Z.PRODUCT_NAME
FROM    (
            /********************************************
             * 2. FOOD_PRODUCT의 테이블과 합침
             ********************************************/
            SELECT
                    Y.*
                  , (
                        /********************************************
                         * 1. 카테고리별 가장 높은가격 데이터를 만듦
                         ********************************************/
                        SELECT
                                MAX(X.PRICE)
                        FROM    FOOD_PRODUCT X
                        WHERE   1=1
                        AND     X.CATEGORY  = Y.CATEGORY
                        GROUP BY
                                X.CATEGORY
                    )   AS      MAX_PRICE
            FROM    FOOD_PRODUCT Y
            WHERE   1=1
        )   Z
WHERE   1=1
AND     Z.PRICE     = Z.MAX_PRICE
AND     Z.CATEGORY  IN	(
            SELECT  DISTINCT TRIM(REGEXP_SUBSTR('과자,국,김치,식용유', '[^,]+', 1, LEVEL)) CATEGORIES
            FROM    DUAL
            CONNECT BY LEVEL <= REGEXP_COUNT('과자,국,김치,식용유',',') + 1
        )
GROUP BY
        Z.CATEGORY
      , Z.PRODUCT_NAME
ORDER BY
        MAX(Z.MAX_PRICE)    DESC
;
