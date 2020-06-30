package com.lea.leet.datastructure.graphf;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraShortestPath2 {

    public static final Integer infinity = 10000;

    public static int shortestPath(int src, int dst, int[][] graph) {

        int[] visited = new int[graph.length + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(src, 0));
        while (!pq.isEmpty()) {
            Node t = pq.poll();

            //如果是重点
            if (t.node == dst) {
                return t.cost;
            }

            //如果当前节点已经遍历过，跳过当前节点
            if (visited[t.node] == 1) {
                continue;
            }
            visited[t.node] = 1;
            for (int i = 0; i < graph.length; i++) {
                if (graph[t.node][i] != infinity && visited[i] == 0) {
                    pq.add(new Node(i, t.cost + graph[t.node][i]));
                }
            }

        }

        return -1;
    }

    public static class Node implements Comparable<Node> {

        public int node;
        public int cost;

        public Node() {
        }

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
