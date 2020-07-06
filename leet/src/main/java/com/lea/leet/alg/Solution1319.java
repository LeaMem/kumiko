package com.lea.leet.alg;

public class Solution1319 {

    public int makeConnected(int n, int[][] connections) {

        int[] parent = new int[n];
        int cnt = n - 1;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int has = 0;
        for (int[] connection : connections) {
            if (union(parent, connection[0], connection[1])) {
                cnt--;
            } else {
                has++;
            }
        }

        return cnt > 0 && cnt > has ? -1 : cnt;
    }

    public boolean union(int[] parent, int p, int q) {
        int rootP = find(parent, p);
        int rootQ = find(parent, q);
        if (rootP == rootQ) {
            return false;
        }
        parent[rootP] = rootQ;
        return true;
    }

    public int find(int[] parent, int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public static void main(String[] args) {

        int[][] connections = {
                {0, 1},
                {0, 2},
                {3, 4},
                {2, 3}
        };

        Solution1319 solution1319 = new Solution1319();
        int ans = solution1319.makeConnected(5, connections);
        System.out.println(ans);

    }

}
