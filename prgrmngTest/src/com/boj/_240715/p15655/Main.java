package com.boj._240715.p15655;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Supplier;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    interface Supp {
        Supplier<String> dli = () -> " ";
    }

    private int[] arr;
    private boolean[] visited;
    private int N;
    private int M;

    /****************************************************************************************
     * 백준 15655번 문제
     *  url         : https://www.acmicpc.net/problem/15655
     ****************************************************************************************/
    public void solution() throws Exception {
        StringTokenizer st1 = new StringTokenizer(br.readLine(), Supp.dli.get());
        N                   = Integer.parseInt(st1.nextToken());
        M                   = Integer.parseInt(st1.nextToken());
        arr                 = new int[N];
        visited             = new boolean[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), Supp.dli.get());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);

        // Do DFS
        for (int i = 0; i < N; i++) {
            DFS(i, M - 1);
            visited[i] = false;
        }
        bw.flush();
    }

    /****************************************************************************************
     * p:   방문처리할 위치
     * m:   남은 depth
     ****************************************************************************************/
    private void DFS(int p, int m) throws Exception {
        visited[p] = true;
        if (m == 0) {
            // 출력
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    bw.write(arr[i] + " ");
                }
            }
            bw.write("\n");
            return ;
        }

        for (int i = p; i < N; i++) {
            if (i + 1 < N && m > 0) {
                DFS(i + 1, m - 1);
                visited[i + 1] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
