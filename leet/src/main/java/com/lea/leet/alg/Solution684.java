package com.lea.leet.alg;

public class Solution684 {

    public int[] findRedundantConnection(int[][] edges) {

        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int rootF = find(parent, edge[0]);
            int rootS = find(parent, edge[1]);
            if (rootF == rootS) {
                return edge;
            }
            parent[rootF] = rootS;
        }

        return new int[0];
    }


    public int find(int[] parent, int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }


}
