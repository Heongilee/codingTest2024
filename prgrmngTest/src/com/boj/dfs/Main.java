package com.boj.dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;


public class Main {
    interface MySupplier {
        Supplier<Integer> ignoreZeroIndex = () -> 1;
    }

    /**********************************************************************************
     * DFS 구현 (인접리스트 버전)
     **********************************************************************************/
    class Graph {
        private int             vrtx;   // 노드
        private List<Integer>[] adj;    // 인접 리스트(adjacency list) 정보

        public Graph(int vrtx) {
            this.vrtx   = vrtx;
            adj         = new LinkedList[vrtx];
            for (int i = 0; i < vrtx; i++) {
                adj[i] = new LinkedList<>();
            }
        }
        /******************************************************************************
         * 간선 추가 메서드
         ******************************************************************************/
        private void addEdge(int v, int w) { adj[v].add(w); }

        /******************************************************************************
         * DFS의 시작
         *  - v:    탐색을 시작할 노드 번호
         ******************************************************************************/
        private void doDFS(int v) {
            boolean[] visited = new boolean[vrtx + MySupplier.ignoreZeroIndex.get()];
            DFS(v, visited);
        }

        /******************************************************************************
         * DFS 서비스 로직
         *  - 노드 v의 방문처리
         *  - 노드 v의 인접한 노드 조회 후 방문하지 않은 노드 재귀호출
         ******************************************************************************/
        private void DFS(int v, boolean[] visited) {
            visited[v] = true;
            System.out.print(v + " ");
            for (Integer w : adj[v]) {
                if (!visited[w]) {
                    DFS(w, visited);
                }
            }
        }
    }

    /************************************************************************
     * Solution:    DFS탐색으로 숫자 1부터 9까지 출력해보자.
     *  - 0번 인덱스는 버린다고 가정
     *  - addEdge() 메서드로 그래프 구현
     ************************************************************************/
    private void solution() {
        int n = 9;
        Graph graph = new Graph(n + MySupplier.ignoreZeroIndex.get());
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 8);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(8, 9);

        graph.doDFS(1);             // 1부터 탐색 시작
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}
