package com.boj._240629.p18512;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.function.Supplier;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    interface MySupplier<T> {
        Supplier<String> delimeter  = () -> " ";
        Supplier<String> errMsg     = () -> "-1";
    }

    /****************************************************************************************
     * 백준 18512번 문제
     *  url         : https://www.acmicpc.net/problem/18512
     *
     *  문제가 좀 이상함... 1000번까지 돌려도 맞는 이유는??
     ****************************************************************************************/
    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), MySupplier.delimeter.get());
        int x   = Integer.parseInt(st.nextToken());
        int y   = Integer.parseInt(st.nextToken());
        int p1  = Integer.parseInt(st.nextToken());
        int p2  = Integer.parseInt(st.nextToken());

        int cnt = 1;
        if (p1 == p2) { bw.write(String.valueOf(p1)); }
        else {
            while (cnt  <= 1000
            &&     p1   != p2
            ) {
                if (p1 > p2) {
                    p2 += y;
                }
                else {
                    p1 += x;
                }
                cnt += 1;
            }
        }

        bw.write((p1 != p2) ? MySupplier.errMsg.get() : String.valueOf(p1));
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
