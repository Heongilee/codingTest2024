package com.boj.sample;

import java.util.function.Function;
import java.util.function.Supplier;


public class Main {
    interface MySupplier {
        Supplier<String> delimiter = () -> ",";
    }
    interface MyPredicate extends MySupplier {

    }
    interface MyFunction extends MyPredicate {
        void MyFunction();

        Function<String, String> t1 = value -> "return value";
    }
    enum MyEnum {
        _032_INCHEON("032", "Y") {
            @Override
            public String getCityName() {
                return "인천광역시";
            }
        };

        /**********************************************************************
         * 유틸성 메서드
         **********************************************************************/
        public static MyEnum getCityByRegionCode(String regionCode) {
            for (MyEnum e : MyEnum.values()) {
                if (e.getRegionCode().equals(regionCode)) {
                    return e;
                }
            }

            throw new RuntimeException("존재하지 않는 지역입니다.");
        }
        
        /**********************************************************************
         * 추상메서드 선언부
         **********************************************************************/
        /**
         * 지역 이름을 반환
         * @return
         */
        public abstract String getCityName();

        /**********************************************************************
         * getter, constructor
         **********************************************************************/
        private String regionCode;
        private String useYn;
        public  String getRegionCode() { return regionCode; }
        public  String getUseYn() { return useYn; }
        MyEnum(String regionCode, String useYn) {
            this.regionCode = regionCode;
            this.useYn      = useYn;
        }
    }

    public static void main(String[] args) {
        String incheon = "032";
        String cityName = MyEnum.getCityByRegionCode(incheon).getCityName();

        System.out.println("cityName = " + cityName);
    }
}
