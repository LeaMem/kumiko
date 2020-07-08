package com.lea.leet.alg;


/**
 * 这里
 */
public class Solution547_UnionFind {

    public int findCircleNum(int[][] M) {
        UF uf = new UF(M.length);

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.size();
    }


    public static class UF {

        private Integer count;

        private int[] parent;

        public UF(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q) {

            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) {
                return;
            }

            parent[rootQ] = rootP;
            count--;
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int size() {
            return this.count;
        }

    }

    public static void main(String[] args) {

        UF uf = new UF(5);
        uf.union(0, 4);
        uf.union(3, 4);
        uf.union(1, 3);
        uf.union(1,2);

        System.out.println(uf.size());

//        int[][] M = {
//                {1, 0, 0, 1},
//                {0, 1, 1, 0},
//                {0, 1, 1, 1},
//                {1, 0, 1, 1}
//        };
//
//        Solution547_UnionFind solution547_unionFind = new Solution547_UnionFind();
//        int ans = solution547_unionFind.findCircleNum(M);
//        System.out.println(ans);

    }

}
