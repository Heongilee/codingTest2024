SELECT
        T.ANIMAL_TYPE
      , NVL(T.NAME, 'No name')
      , T.SEX_UPON_INTAKE
FROM    ANIMAL_INS T
WHERE   1=1
ORDER BY
        T.ANIMAL_ID
;