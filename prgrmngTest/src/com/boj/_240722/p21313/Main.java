package com.boj._240722.p21313;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /****************************************************************************************
     * 백준 21313번 문제
     *  url         : https://www.acmicpc.net/problem/21313
     ****************************************************************************************/
    public void solution() throws Exception {
        int N            = Integer.parseInt(br.readLine());
        int lastNumber   = (N % 2 == 0) ? 2 : 3;

        for (int i = 0; i < N; i++) {
            int result;
            if (i == N - 1) {
                result = lastNumber;
            } else {
                if (i % 2 == 0) {
                    result = 1;
                } else {
                    result = 2;
                }
            }

            bw.write(String.valueOf(result) + " ");
        }

        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
