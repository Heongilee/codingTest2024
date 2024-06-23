package com.boj._240623.p1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.function.Supplier;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    interface MySupplier {
        Supplier<String> delimeter = () -> " ";
    }

    /****************************************************************************************
     * 백준 1000번 문제
     *  url         : https://www.acmicpc.net/problem/1000
     ****************************************************************************************/
    public void solution() throws Exception {
        int result         = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), MySupplier.delimeter.get());

        while (st.hasMoreTokens()) {
            int e = Integer.parseInt(st.nextToken());

            result += e;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
