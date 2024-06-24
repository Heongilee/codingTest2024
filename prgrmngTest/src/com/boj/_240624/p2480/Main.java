package com.boj._240624.p2480;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    interface MySupplier {
        Supplier<String> delimeter = () -> " ";
    }
    interface MyFunction extends MySupplier {
        Function<String, Integer> maxNumber = s -> {
            int result          = 0;
            StringTokenizer st  = new StringTokenizer(s, MySupplier.delimeter.get());

            while (st.hasMoreTokens()) {
                int e = Integer.parseInt(st.nextToken());
                result = (result > e) ? result : e;
            }

            return result;
        };

        Function<Integer, Integer> prc3 = e -> 10000 + e * 1000;
        Function<Integer, Integer> prc2 = e -> 1000 + e * 100;
        Function<Integer, Integer> prc1 = e -> e * 100;
    }

    /****************************************************************************************
     * 백준 2480번 문제
     *  url         : https://www.acmicpc.net/problem/2480
     ****************************************************************************************/
    public void solution() throws Exception {
        int result         = 0;
        String input       = br.readLine();
        StringTokenizer st = new StringTokenizer(input, MySupplier.delimeter.get());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        /************************************************************************************
         * 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금
         ************************************************************************************/
        if (a == b && b == c && c == a) {
            bw.write(String.valueOf(MyFunction.prc3.apply(a)));
        }

        /************************************************************************************
         * 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금
         ************************************************************************************/
        else if (a == b || c == a) {
            bw.write(String.valueOf(MyFunction.prc2.apply(a)));
        }
        else if (b == c) {
            bw.write(String.valueOf(MyFunction.prc2.apply(b)));
        }

        /************************************************************************************
         * 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금
         ************************************************************************************/
        else {
            bw.write(String.valueOf(
                MyFunction.prc1.apply(MyFunction.maxNumber.apply(input))
            ));
        }

        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
