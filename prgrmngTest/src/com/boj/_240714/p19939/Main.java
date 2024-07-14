package com.boj._240714.p19939;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.function.Function;
import java.util.function.Supplier;


public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    interface MySupplier {
        Supplier<String> delimiter  = () -> " ";
        Supplier<String> errMsg     = () -> "-1";
    }
    interface MyPredicate extends MySupplier {}
    interface MyFunction extends MyPredicate {
        void MyFunction();

        /****************************************************************************
         * 등차수열 Σ K
         ****************************************************************************/
        Function<Integer, Integer> summingSeq = n -> {
            Integer result = 0;
            for (int i = 1; i <= n; i++) { result += i; }
            return result;
        };
    }

    /****************************************************************************************
     * 백준 19939 문제
     *  url         : https://www.acmicpc.net/problem/19939
     ****************************************************************************************/
    private void solution() throws Exception {
        String[] split  = br.readLine().split(MySupplier.delimiter.get());
        int N           = Integer.parseInt(split[0]);
        int K           = Integer.parseInt(split[1]);

        /****************************************************************
         * 각 바구니에 담을 수 있는 최소 공의 개수는 N < Σ K
         ****************************************************************/
        Integer sum     = MyFunction.summingSeq.apply(K);

        if (N < sum) {
            bw.write(MySupplier.errMsg.get());
        } else {
            /****************************************************************
             * 각 바구니마다 서로 다른 수의 공 개수 분배
             *  - rem:  분배하고 남은 공
             *  - sol:  남은 공으로 각 바구니에 공들을 분배한 사이클 수
             ****************************************************************/
            int rem = N - sum;
            int sol = rem / K;
            rem     = rem % K;
            bw.write(String.valueOf(K + sol + ((rem > 0) ? 1 : 0) - (1 + sol)));
        }

        bw.flush();
    }
    public static void main(String[] args)  throws Exception {
        new Main().solution();
    }

}
