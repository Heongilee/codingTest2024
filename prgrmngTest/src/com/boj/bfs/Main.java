package com.boj.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;


public class Main {
    interface MySupplier {
        Supplier<Integer> ignoreZeroIndex = () -> 1;
    }

    /**********************************************************************************
     * BFS 구현 (인접리스트 버전)
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
         * BFS 서비스 로직
         *  - s:    탐색을 시작할 노드 번호
         *  -   가. 첫 시작 노드(s)를 방문처리 후 큐 삽입 (현재 s노드)
         *  -   나. 현재의 인접노드를 조회해 미방문 시 방문처리 후 큐 삽입
         *  -   다. queue가 빌 때 까지 나. 를 반복
         ******************************************************************************/
        private void doBFS(int s) {
            boolean visited[] = new boolean[vrtx + MySupplier.ignoreZeroIndex.get()];
            LinkedList<Integer> queue = new LinkedList<>();

            visited[s] = true;
            queue.add(s);
            while (!queue.isEmpty()) {
                int v = queue.poll();
                System.out.print(v + " ");

                for (Integer n : adj[v]) {
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    }

    /************************************************************************
     * Solution:    BFS탐색으로 숫자 1부터 9까지 출력해보자.
     *  - 0번 인덱스는 버린다고 가정
     *  - addEdge() 메서드로 그래프 구현
     ************************************************************************/
    private void solution() {
        int n = 9;
        Graph graph = new Graph(n + MySupplier.ignoreZeroIndex.get());
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 8);
        graph.addEdge(6, 9);

        graph.doBFS(1);             // 1부터 탐색 시작
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}
