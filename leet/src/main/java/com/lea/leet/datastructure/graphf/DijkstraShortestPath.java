package com.lea.leet.datastructure.graphf;

public class DijkstraShortestPath implements IShortestPath {

    @Override
    public int[] shortestPath(int[][] graph, int start) {

        final int length = graph.length;
        boolean[] visited = new boolean[length];
        int[] shortestPath = new int[length];

        visited[start] = true;
        shortestPath[start] = 0;


        for (int i = 1; i < length; i++) {

            //visit k
            int k = -1;
            int path = Integer.MAX_VALUE;

            for (int j = 1; j < length; j++) {
                if (!visited[j] && graph[start][j] < path) {
                    path = graph[start][j];
                    k = j;
                }
            }

            visited[k] = true;
            shortestPath[k] = path;

            for (int j = 1; j < length; j++) {

                if (!visited[j] && graph[start][k] + graph[k][j] < graph[start][j]) {
                    graph[start][j] = graph[start][k] + graph[k][j];
                }

            }

        }

        return shortestPath;

    }


    public static void main(String[] args) {

        final int M = 10000; // 代表正无穷
        // 二维数组每一行分别是 A、B、C、D、E 各点到其余点的距离,
        // A -> A 距离为0, 常量M 为正无穷
        int[][] graph = {
                {0, 4, M, 2, M},
                {4, 0, 4, 1, M},
                {M, 4, 0, 1, 3},
                {2, 1, 1, 0, 7},
                {M, M, 3, 7, 0}
        };
        int start = 0;
        IShortestPath shortestPath = new DijkstraShortestPath();
//        int[] shortPath = shortestPath.shortestPath(graph, start);
        for (int i = 0; i < graph.length; i++) {
            System.out.println("从" + start + "出发到" + i + "的最短距离为：" + DijkstraShortestPath2.shortestPath(0, i, graph));
        }

    }
}
