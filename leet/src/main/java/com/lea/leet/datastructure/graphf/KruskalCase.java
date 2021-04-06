package com.lea.leet.datastructure.graphf;

import java.util.Arrays;

public class KruskalCase {

    private int edgeNum; //边的个数
    private char[] vertexs; //顶点数组
    private int[][] matrix; //邻接矩阵
    //表示不联通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}
        };
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        kruskalCase.print();
        kruskalCase.kruskal();
    }

    //构造器
    public KruskalCase(char[] vertexs, int[][] matrix) {
        int vlen = vertexs.length;

        //复制拷贝
        this.vertexs = new char[vlen];
        for(int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }

        //初始化表
        this.matrix = new int[vlen][vlen];
        for(int i = 0; i < vlen; i++) {
            for(int j= 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        for(int i =0; i < vlen; i++) {
            for(int j = i+1; j < vlen; j++) {
                if(this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    //克鲁斯卡尔算法
    public void kruskal() {
        int index = 0;
        int[] ends = new int[edgeNum];
        EData[] rets = new EData[edgeNum];

        EData[] edges = getEdges();
        System.out.println("图的边的集合=" + Arrays.toString(edges) + "共"+ edges.length); //12

        //排序
        sortEdges(edges);

        //遍历数组
        for(int i=0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            if(m != n) {
                ends[m] = n;
                rets[index++] = edges[i];
            }
        }
        System.out.println("×îÐ¡Éú³ÉÊ÷Îª");
        for(int i = 0; i < index; i++) {
            System.out.println(rets[i]);
        }
    }


    public void print() {
        System.out.println("邻接矩阵: \n");
        for(int i = 0; i < vertexs.length; i++) {
            for(int j=0; j < vertexs.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    //对边排序
    private void sortEdges(EData[] edges) {
        for(int i = 0; i < edges.length - 1; i++) {
            for(int j = 0; j < edges.length - 1 - i; j++) {
                if(edges[j].weight > edges[j+1].weight) {//½»»»
                    EData tmp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = tmp;
                }
            }
        }
    }

    //顶点的值
    private int getPosition(char ch) {
        for(int i = 0; i < vertexs.length; i++) {
            if(vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    //获取图中的边
    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for(int i = 0; i < vertexs.length; i++) {
            for(int j=i+1; j <vertexs.length; j++) {
                if(matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    //获取终点
    private int getEnd(int[] ends, int i) {
        while(ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    //边
    public static class EData {
        char start; //起点
        char end; //终点
        int weight; //权值
        //构造器
        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "EData [<" + start + ", " + end + ">= " + weight + "]";
        }
    }

}


