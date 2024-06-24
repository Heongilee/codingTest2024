package com.boj._240624.p14405;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /****************************************************************************************
     * 백준 14405번 문제
     *  url         : https://www.acmicpc.net/problem/14405
     ****************************************************************************************/
    public void solution() throws Exception {
        /*************************************************************************************
         * dicMap
         *     - key    : 음절의 첫 글자
         *     - value  :
         *          [0] 음절 전체
         *          [1] 음절 길이
         *************************************************************************************/
        Map<String, List<String>> dicMap = Map.of(
                  "p", List.of("pi", "2")
                , "k", List.of("ka", "2")
                , "c", List.of("chu", "3")
        );

        /*************************************************************************************
         * 1. 음절의 첫 글자로 찾을 수 있는 음절리스트를 map에서 찾음
         *************************************************************************************/
        String S    = br.readLine();
        int idx;
        for (idx = 0; idx < S.length();) {
            String key          = String.valueOf(S.charAt(idx));
            List<String> list   = dicMap.get(key);

            /*************************************************************************************
             *  1.1. break
             *      - map에서 못 찾을 시
             *      - substring을 구하려는데 길이 초과 시
             *      - word가 음절과 다를 시
             *************************************************************************************/
            if (list == null
            ||  idx + Integer.parseInt(list.get(1)) > S.length()
            ||  !list.get(0).equals(S.substring(idx, idx + Integer.parseInt(list.get(1))))
            ) {
                break;
            }

            /*************************************************************************************
             *  1.2. 음절 길이만큼 인덱스 증가
             *************************************************************************************/
            idx += Integer.parseInt(list.get(1));
        }

        /*************************************************************************************
         * 2. 응답 출력 (무입력은 무효)
         *************************************************************************************/
        bw.write( (idx != 0 && idx == S.length()) ? "YES" : "NO" );
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
