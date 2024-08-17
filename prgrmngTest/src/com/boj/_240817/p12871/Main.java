package com.boj._240817.p12871;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /****************************************************************************************
     * 백준 12871번 문제
     *  url         : https://www.acmicpc.net/problem/12871
     ****************************************************************************************/
    public void solution() throws Exception {
        String s = br.readLine();
        String t = br.readLine();

        String A = "";
        String B = "";
        for (int i = 0; i < t.length(); i++) {
            A += s;
        }
        for (int i = 0; i < s.length(); i++) {
            B += t;
        }

        bw.write((A.equals(B))? "1" : "0");
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
