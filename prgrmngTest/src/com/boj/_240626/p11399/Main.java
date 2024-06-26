package com.boj._240626.p11399;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.function.Supplier;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    interface MySupplier {
        Supplier<String> delimeter = () -> " ";
    }

    /****************************************************************************************
     * 백준 11399번 문제
     *  url         : https://www.acmicpc.net/problem/11399
     ****************************************************************************************/
    public void solution() throws Exception {
        /************************************************************************************
         * 1. 숫자 N과 N개의 숫자를 입력받음
         ************************************************************************************/
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), MySupplier.delimeter.get());
        List<Integer> P = new ArrayList<>();
        st.asIterator().forEachRemaining(e -> P.add(Integer.parseInt(String.valueOf(e))));

        /************************************************************************************
         * 2. 정렬
         ************************************************************************************/
        Collections.sort(P);

        /************************************************************************************
         * 3. 누적합 계산
         ************************************************************************************/
        List<Integer> accSum = new ArrayList<>();
        int acc = 0;
        for (Integer i : P) {
            acc += i;
            accSum.add(acc);
        }

        /************************************************************************************
         * 4. 결과 출력
         ************************************************************************************/
        bw.write(String.valueOf(accSum.stream().mapToInt(Integer::valueOf).sum()));
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
